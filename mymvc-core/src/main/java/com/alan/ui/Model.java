package com.alan.ui;

import java.util.Collection;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 17:38 2018/8/7
 * modified By：
 */
public interface Model {

    Model addAttribute(String attributeName, Object attributeValue);

    Model addAttribute(Object attributeValue);

    Model addAllAttributes(Collection<?> attributeValues);

    Model addAllAttributes(Map<String,?> attributes);

    Model mergeAttribute(Map<String,?> attributes);

    Model containsAttribute(String attributeName);

    Map<String,Object> asMap();
}
