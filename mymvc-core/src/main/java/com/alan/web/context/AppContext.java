package com.alan.web.context;

import com.alan.utils.ConfigUtils;
import com.alan.utils.PkgUtils;
import com.alan.utils.StringUtils;
import com.alan.web.bind.annotation.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: alan.peng
 * description:
 * date: create in 15:56 2018/8/6
 * modified By：
 */
public class AppContext {
    private static final Map<String,String> clazeMap = new ConcurrentHashMap<>();
    private static final Map<String,String> beanMap = new ConcurrentHashMap<>();

    private static final boolean IS_AOP_ENABLE = ConfigUtils.getBoolean("aop.enable",true);

    static {
        Set<Class<?>> clazes = null;

        try {
            clazes = PkgUtils.findClazeByAnnotation(ConfigUtils.getProperty("package.scan"), Component.class);
            for (Class claze: clazes) {
                clazeMap.put(StringUtils.lowerFirst(claze.getSimpleName()),claze.getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
