package com.alan.ui;

import com.alan.utils.StringUtils;

import java.util.Collection;

/**
 * author: alan.peng
 * description:
 * date: create in 15:56 2018/9/2
 * modified By：
 */
public class Conventions {

    public static String getVariableName(Object attributeValue) {
        if (attributeValue instanceof Collection) {
            return StringUtils.lowerFirst(((Collection) attributeValue).iterator().next().getClass().getSimpleName());
        }
        return StringUtils.lowerFirst(attributeValue.getClass().getSimpleName());
    }
}
