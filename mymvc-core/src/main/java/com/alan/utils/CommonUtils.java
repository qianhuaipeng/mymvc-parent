package com.alan.utils;

/**
 * author: alan.peng
 * description:
 * date: create in 16:46 2018/8/2
 * modified By：
 */
public class CommonUtils {

    public static <T> boolean isEmpty(T[] arr){
        return arr == null || arr.length == 0;
    }
}
