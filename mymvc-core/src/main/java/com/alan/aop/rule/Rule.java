package com.alan.aop.rule;

import java.lang.reflect.Method;

/**
 * author: alan.peng
 * description:
 * date: create in 14:06 2018/8/6
 * modified By：
 */
public abstract class Rule {

    protected String rule;

    protected boolean isVaild = true;

    public Rule(String rule) {
        this.rule = rule;
    }

    public abstract boolean match(Method targetMethod);
}
