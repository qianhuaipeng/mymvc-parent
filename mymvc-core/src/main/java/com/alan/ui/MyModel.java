package com.alan.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 15:46 2018/9/2
 * modified By：
 */
public class MyModel extends HashMap<String , Object> implements Model {

    public MyModel() {
    }

    public MyModel(String attributeName, Object attributeValue) {
        addAttribute(attributeName, attributeValue);
    }

    public MyModel(Object attributeValue) {
        addAttribute(attributeValue);
    }

    @Override
    public Model addAttribute(String attributeName, Object attributeValue) {
        put(attributeName,attributeValue);
        return this;
    }

    @Override
    public Model addAttribute(Object attributeValue) {
        if (attributeValue instanceof Collection && ((Collection) attributeValue).isEmpty()) {
            return this;
        }
        return addAttribute(Conventions.getVariableName(attributeValue));
    }

    @Override
    public Model addAllAttributes(Collection<?> attributeValues) {
        if (attributeValues != null) {
            for (Object attributeValue : attributeValues) {
                addAttribute(attributeValue);
            }
        }
        return this;
    }

    @Override
    public Model addAllAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            putAll(attributes);
        }
        return this;
    }

    @Override
    public Model mergeAttribute(Map<String, ?> attributes) {
        if (attributes != null) {
            for (String key : attributes.keySet()) {
                if (!containsKey(key)) {
                    put(key, attributes.get(key));
                }
            }
        }
        return this;
    }

    @Override
    public boolean containsAttribute(String attributeName) {
        return containsKey(attributeName);
    }

    @Override
    public Map<String, Object> asMap() {
        return this;
    }
}
