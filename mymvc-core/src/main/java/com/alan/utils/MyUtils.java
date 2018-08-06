package com.alan.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 13:58 2018/8/6
 * modified By：
 */
public class MyUtils {

    public static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> List<T> newLinkedList(){
        return new LinkedList<T>();
    }

    public static <T> boolean isEmpty(T[] arr) {
        return arr == null || arr.length == 0;
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
    public static <A extends Annotation> boolean isAnnotated(Method method, Class<A> annoClaze){
        return method.getAnnotation(annoClaze) != null;
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
