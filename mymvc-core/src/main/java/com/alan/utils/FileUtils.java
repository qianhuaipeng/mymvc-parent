package com.alan.utils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 16:32 2018/8/2
 * modified By：
 */
public class FileUtils {

    public static List<File> findFiles(final String fileExtension){
        List<File> files = new LinkedList<File>();
        try {
            URL url = FileUtils.class.getResource("/");
            if (url == null) {
                return files;
            }
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) { //
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                File dir = new File(filePath);
                if (!dir.exists() || !dir.isDirectory())
                    return files;
                File[] targetFiles = dir.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().endsWith(fileExtension);
                    }
                });
                if (!CommonUtils.isEmpty(targetFiles)) {
                    files.addAll(Arrays.asList(targetFiles));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public static void copy(String file, OutputStream out) throws IOException {
        FileInputStream in = new FileInputStream(file);
        int c;
        byte buffer[] = new byte[1024];
        while ((c = in.read(buffer)) != -1) {
            for (int i= 0; i < c; i++) {
                out.write(buffer[i]);
            }
        }
        in.close();
        out.close();
    }
}
