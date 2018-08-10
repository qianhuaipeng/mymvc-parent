package com.alan.aop;

import com.alan.aop.annotation.Pointcut;
import com.alan.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

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


    public JoinPoint(Class<?> aspectClaze) {
        List<Method> pointcutMethods = MyUtils.findMethods(aspectClaze, Pointcut.class);
        if (MyUtils.isEmpty(pointcutMethods))
            throw new IllegalArgumentException("There is no method with annotation Pointcut.class");

        if (pointcutMethods.size() > 1)
            throw new IllegalArgumentException("There are more than one method annotated with Pointcut.class");

        this.aspectClaze = aspectClaze;

        try {
            this.aspectInstance = aspectClaze.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.pointcutMethod = pointcutMethods.get(0);
        Pointcut ann;
        ann = pointcutMethod.getAnnotation(Pointcut.class);

    }
}
