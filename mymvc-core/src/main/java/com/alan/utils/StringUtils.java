package com.alan.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: alan.peng
 * description:
 * date: create in 14:50 2018/8/6
 * modified By：
 */
public class StringUtils {

    public static final Pattern PATTERN_CONFIG = Pattern.compile("(\\$\\{([^}]+)\\})");
    public static final Pattern PATTERN_PATH_VARIABLE = Pattern.compile("(\\{([^}]+)\\})");

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


    /**
     *
     * @param url
     * @return
     */
    public static String replaceConfig(String url){
        Matcher m = PATTERN_CONFIG.matcher(url);
        if (!m.find())
            return url;
        String key, value;
        int start = 0, offset = 0;
        StringBuilder sb = new StringBuilder(url);
        if (m.find(start)) {
            key = m.group(2);
            value = ConfigUtils.getProperty(key);
            sb.replace(m.start() + offset , m.end() + offset , value);
            offset += value.length() - (key.length() + 3); // 3 ="${}".length
            start = m.end();
        }
        return sb.toString();
    }
    public static String decode(String s) {
        try {
            return URLDecoder.decode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
