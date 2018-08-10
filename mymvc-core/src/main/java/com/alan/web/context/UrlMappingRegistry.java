package com.alan.web.context;

import com.alan.utils.ConfigUtils;
import com.alan.utils.MyUtils;
import com.alan.utils.PkgUtils;
import com.alan.web.bind.annotation.Component;
import com.alan.web.bind.annotation.Controller;
import com.alan.web.bind.annotation.RequestMapping;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * author: alan.peng
 * description:
 * date: create in 9:34 2018/8/10
 * modified By：
 */
public class UrlMappingRegistry {

    public static final Logger LOGGER = LoggerFactory.getLogger(UrlMappingRegistry.class);

    private static final Multimap<String, UrlMapping> urlMap = ArrayListMultimap.create();

    private static final List<UrlMapping> pathUrls = MyUtils.newArrayList();

    public UrlMappingRegistry() {
    }

    static {
        Set<Class<?>> clazes = null;

        try {
            clazes = PkgUtils.findClazeByAnnotation(ConfigUtils.getProperty("package.scan"), Controller.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() {

    }

    public static void register(Collection<Class<?>> controllers) {
        if (controllers == null || controllers.isEmpty())
            return;

        for (Class<?> claze: controllers) {
            register(claze);
        }
    }

    public static void register(Class<?> controller){
        String[] urls = null;
        String clazeUrl = null;
        if (MyUtils.isAnnotated(controller, RequestMapping.class)) {
            urls = controller.getAnnotation(RequestMapping.class).value();
            if (MyUtils.isEmpty(urls) || urls.length > 1) {
                LOGGER.error("RequestMapping on class {} is invalid.", controller.getName());
                return;
            } else
                clazeUrl = urls[0];
        }

        Method[] methods = controller.getMethods();
        UrlMapping urlMapping = null;
        boolean flag = false;
        for (Method method: methods) {
            if (!MyUtils.isAnnotated(method,RequestMapping.class))
                continue;

            method.setAccessible(true);
            urls = method.getAnnotation(RequestMapping.class).value();
            flag = false;
            for (String url: urls) {

            }
        }
    }

    public static UrlMapping buildUrlMapping(Method method, String clazeUrl , String url){
        UrlMapping urlMapping = new UrlMapping(method);

        return urlMapping;
    }
}
