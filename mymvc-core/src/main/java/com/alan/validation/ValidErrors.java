package com.alan.validation;

import com.alan.utils.MyUtils;
import com.alibaba.fastjson.JSON;

import java.util.Collection;
import java.util.TreeMap;

/**
 * author: alan.peng
 * description:
 * date: create in 15:44 2018/9/10
 * modified By：
 */
public class ValidErrors extends TreeMap<String, Collection<String>>{

    public void put(String key , String value) {
        Collection<String> c = get(key);
        if (c == null) {
            c = MyUtils.newLinkedList();
            put(key, c);
        }
        c.add(value);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
