package com.alan.aop.rule;

import java.util.regex.Matcher;

/**
 * author: alan.peng
 * description:
 * date: create in 13:51 2018/8/8
 * modified By：
 */
public class MyRuleFactory {

    public static MyRule parse(String rule) {
        Matcher m = MyAnnotationRule.matcher(rule);
        if (m.find()) {
            return MyAnnotationRule.parse(rule);
        }
        return null;
    }
}
