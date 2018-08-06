package com.alan.utils;

import sun.tools.jar.resources.jar;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * author: alan.peng
 * description:
 * date: create in 14:47 2018/8/6
 * modified By：
 */
public class PkgUtils {

    /**
     * 获取指定包下面的指定的所有注解的类
     *
     * @param pkgName
     * @param annoClaze
     * @param <A>
     * @return
     * @throws Exception
     */
    public static <A extends Annotation> Set<Class<?>> findClazeByAnnotation(String pkgName, Class<A> annoClaze) throws Exception {
        if (StringUtils.isEmpty(pkgName))
            return null;

        Set<Class<?>> list = new LinkedHashSet<>();
        Set<Class<?>> clazes = null;

        String[] pkgs = pkgName.split("\\s*;\\s*");
        for (String pkg : pkgs) {
            if (pkg.isEmpty())
                continue;
            clazes = getClazes(pkg);
            for (Class claze: clazes) {
                if (claze.isAnnotation())
                    continue;
                if (MyUtils.isAnnotated(claze,annoClaze)) {
                    list.add(claze);
                }
            }
        }
        return list;
    }

    /**
     * 根据包名获取下面的所有class
     *
     * @param pkg
     * @return
     */
    public static Set<Class<?>> getClazes(String pkg) {
        Set<Class<?>> classes = new LinkedHashSet<>();
        boolean recursive = true;
        String pkgDirName = pkg.replace('.', '/');
        try {
            URL url = PkgUtils.class.getClassLoader().getResource(pkgDirName);
            if (url == null)
                return classes;
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) { // 如果是以文件的形式读取
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                findClazesByFile(pkg, filePath, recursive, classes);
            }
            if ("jar".equals(protocol)) { //如果是以jar包的形式读取
                JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                findClazesByJar(pkg, jarFile, recursive, classes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public static void findClazesByFile(String pkgName, String pkgPath, final boolean recursive, Set<Class<?>> classes) {
        File dir = new File(pkgPath);
        if (!dir.exists() || !dir.isDirectory())
            return;
        File[] dirFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        String className = null;
        Class<?> claze = null;
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClazesByFile(pkgName, pkgPath, recursive, classes);
            } else {
                className = file.getName();
                className = className.substring(0, className.length() - 6);
                claze = getClaze(pkgName, className);
                if (claze != null) {
                    classes.add(claze);
                }
            }
        }
    }

    public static void findClazesByJar(String pkgName, JarFile jar, final boolean recursive, Set<Class<?>> classes) {
        String packageDirName = pkgName.replace('.', '/');
        Enumeration<JarEntry> jarEntries = jar.entries();
        JarEntry jarEntry;
        String name, className;
        Class<?> claze;
        while (jarEntries.hasMoreElements()) {
            jarEntry = jarEntries.nextElement();
            name = jarEntry.getName();
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }
            if (name.startsWith(packageDirName)) {
                int index = name.lastIndexOf('/');
                if (index > -1) {// 以"/"结尾 是一个包
                    pkgName = name.substring(0, index).replace('/', '.');// 获取包名
                    // 把"/"替换成"."
                }
                if ((index > -1) || recursive) {
                    if (name.endsWith(".class") && !jarEntry.isDirectory()) {
                        className = name.substring(pkgName.length() + 1, name.length() - 6);// 去掉后面的".class"
                        // 获取真正的类名
                        claze = getClaze(pkgName, className);
                        if (claze != null) {
                            classes.add(claze);
                        }
                    }
                }
            }
        }

    }

    public static Class<?> getClaze(String pkgName, String clazeName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(pkgName + '.' + clazeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
