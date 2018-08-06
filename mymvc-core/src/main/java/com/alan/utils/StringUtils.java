package com.alan.utils;

/**
 * author: alan.peng
 * description:
 * date: create in 14:50 2018/8/6
 * modified By：
 */
public class StringUtils {

    public static boolean isBlack(String str){
        return str == null || str.trim().isEmpty();
    }
    public static boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }

    /**
     * 第一个字母小写
     * @param str
     * @return
     */
    public static String lowerFirst(String str){
        if (isEmpty(str))
            return str;

        char ch = str.charAt(0);
        if (ch < 'A' || ch > 'Z') {
            return str;
        }

        char[] cs = str.toCharArray();
        cs[0] = Character.toLowerCase(ch);
        return String.valueOf(cs);
    }
}
