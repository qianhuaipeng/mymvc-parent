package com.alan.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * author: alan.peng
 * description:
 * date: create in 14:01 2018/8/6
 * modified By：
 */
public class JoinPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(JoinPoint.class);

    private Class<?> aspectClaze = null;

    private Object aspectInstance = null;

    private Method pointcutMethod = null;

    private Method beforeMethod = null;

    private Method aroundMethod = null;

    private Method afterMethod = null;


}
