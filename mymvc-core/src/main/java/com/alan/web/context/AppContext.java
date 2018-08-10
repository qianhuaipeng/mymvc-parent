package com.alan.web.context;

import com.alan.aop.MyHttpServletRequest;
import com.alan.aop.MyHttpServletResponse;
import com.alan.aop.MyHttpSession;
import com.alan.domian.annotation.Autowired;
import com.alan.domian.annotation.Value;
import com.alan.utils.ConfigUtils;
import com.alan.utils.MyUtils;
import com.alan.utils.PkgUtils;
import com.alan.utils.StringUtils;
import com.alan.web.bind.annotation.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
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
    private static final Map<String,Object> beanMap = new ConcurrentHashMap<>();

    private static final boolean IS_AOP_ENABLE = ConfigUtils.getBoolean("aop.enable",true);

    static {
        Set<Class<?>> clazes = null;

        try {
            clazes = PkgUtils.findClazeByAnnotation(ConfigUtils.getProperty("package.scan"), Component.class);
            for (Class claze: clazes) {
                clazeMap.put(StringUtils.lowerFirst(claze.getSimpleName()),claze.getName());
            }
            clazeMap.put("httpServletRequest", HttpServletRequest.class.getName());
            beanMap.put("httpServletRequest", new MyHttpServletRequest());

            clazeMap.put("httpServletResponse", HttpServletResponse.class.getName());
            beanMap.put("httpServletResponse",new MyHttpServletResponse());

            clazeMap.put("httpSession", HttpSession.class.getName());
            beanMap.put("httpSession", new MyHttpSession());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() {

    }

    public static <T> T setBean(T entity) {
        String className = StringUtils.lowerFirst(entity.getClass().getSimpleName());
        T result = (T) beanMap.get(className);
        beanMap.put(className,entity);
        return result;
    }

    public static <T> T setBean(String id, T entity) {
        T result = (T) beanMap.get(id);
        beanMap.put(id,entity);
        return result;
    }

    public static <T> T getBean(String beanId){
        if (beanMap.containsKey(beanId))
            return (T) beanMap.get(beanId);

        String className = clazeMap.get(beanId);
        Class<T> claze = null;

        try {
            claze = (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return getBean(claze);
    }

    public static <T> T getBean(Class<T> claze) {
        String className = StringUtils.lowerFirst(claze.getSimpleName());
        if (beanMap.containsKey(className))
            return (T) beanMap.get(className);
        try {
            T entity = autowireClaze(claze);
            beanMap.put(className,entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> T autowireClaze(Class<T> claze) throws Exception {
        boolean isComponent = MyUtils.isAnnotated(claze, Component.class);
        T entity = claze.newInstance();
        if (isComponent) {
            Field[] fields = claze.getDeclaredFields();
            for (Field field: fields ) {
                autowireField(entity, field);
            }
        }
        return entity;
    }

    private static <T> Object autowireField(T entity, Field field) throws Exception {
        if (MyUtils.isAnnotated(field, Autowired.class)) {
            Object value = getBean(StringUtils.lowerFirst(field.getType().getSimpleName()));
            if (value == null && field.getAnnotation(Autowired.class).required()) {
                throw new Exception(String.format("Field %s in %s is not found the autowired bean.", field.getName(),
                        entity.getClass().getName()));
            }

            field.setAccessible(true);
            field.set(entity,value);
            return value;
        }

        Value ann = field.getAnnotation(Value.class);
        if (ann == null)
            return null;
        String key = ann.value();
        if (StringUtils.isEmpty(key))
            return key;
        String value = key;
        if (MyUtils.isBindKey(key)) {
            value = MyUtils.getBindKey(key);
        }

        Object targetValue = MyUtils.convert(value, field.getType());
        if (targetValue != null) {
            field.setAccessible(true);
            field.set(entity, targetValue);
            return targetValue;
        }

        throw new Exception(String.format("Field %s in %s is not support autowired.", field.getName(),
                entity.getClass().getName()));
    }
}
