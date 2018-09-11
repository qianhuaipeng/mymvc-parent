package com.alan.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * author: alan.peng
 * description:
 * date: create in 13:58 2018/8/6
 * modified By：
 */
public class MyUtils {
    public static <T, V> Map<T,V> newHashMap(){
        return new HashMap<T, V>();
    }

    public static <T, V> Map<T, V> newHashMap(int len) {
        return new HashMap<T, V>((int) (len / 0.75) + 1);
    }

    public static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> List<T> newLinkedList(){
        return new LinkedList<T>();
    }

    public static boolean isBindKey(String key) {
        return key.startsWith("${") && key.endsWith("}");
    }

    /**
     * ${key} -> key
     *
     * @param key
     * @return
     */
    public static String getBindKey(String key) {
        return key.substring(2, key.length() - 1);
    }

    public static <T> boolean isEmpty(T[] arr) {
        return arr == null || arr.length == 0;
    }
    public static <T> boolean isEmpty(Collection<T> c) {
        return c == null || c.isEmpty();
    }


    public static Object convert(String value, Class<?> targetClass) {
        if (String.class.equals(targetClass)) {
            return value;
        }

        if (Integer.TYPE.equals(targetClass) || Integer.class.equals(targetClass)) {
            if (value == null)
                return 0;
            else
                return Integer.valueOf(value);
        }

        if (Long.TYPE.equals(targetClass) || Long.class.equals(targetClass)) {
            if (value == null)
                return 0;
            else
                return Long.valueOf(value);
        }

        if (Double.TYPE.equals(targetClass) || Double.class.equals(targetClass)) {
            if (value == null)
                return 0;
            else
                return Double.valueOf(value);
        }

        if (Float.TYPE.equals(targetClass) || Float.class.equals(targetClass)) {
            if (value == null)
                return 0;
            else
                return Float.valueOf(value);
        }

        if (Boolean.TYPE.equals(targetClass) || Boolean.class.equals(targetClass)) {
            if (value == null)
                return false;
            else
                return Boolean.valueOf(value);
        }

        return null;
    }
    public static <A extends Annotation> boolean isAnnotated(Class claze, Class<A> annoClaze) {
        if (claze.getAnnotation(annoClaze) != null)
            return true;
        Annotation[] annos = claze.getAnnotations();
        for (Annotation anno: annos) {
            if (anno.annotationType().getAnnotation(annoClaze) != null)
                return true;
        }
        return false;
    }

    public static <A extends Annotation> boolean isAnnotated(Field field, Class<A> annoClaze) {
        return field.getAnnotation(annoClaze) != null;
    }
    public static <A extends Annotation> boolean isAnnotated(Method method, Class<A> annoClaze){
        return method.getAnnotation(annoClaze) != null;
    }

    public static boolean contains(Annotation[] annos, Class<? extends Annotation> annoClaze){
        for (Annotation annotation : annos) {
            if (annotation.annotationType() == annoClaze)
                return true;
        }
        return false;
    }
    public static <A extends Annotation> List<Method> findMethods(Class<?> claze, Class<A> annoClaze){
        Method[] methods = claze.getDeclaredMethods();
        if (MyUtils.isEmpty(methods))
            return null;

        List<Method> list = newLinkedList();
        for (Method method: methods) {
            if (isAnnotated(method, annoClaze)) {
                list.add(method);
            }
        }
        return list;
    }
}
