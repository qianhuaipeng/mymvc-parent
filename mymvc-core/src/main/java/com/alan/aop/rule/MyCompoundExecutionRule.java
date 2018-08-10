package com.alan.aop.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * author: alan.peng
 * description:
 * date: create in 13:54 2018/8/8
 * modified By：
 */
public class MyCompoundExecutionRule {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyCompoundExecutionRule.class);

    public static final Pattern RULE_PATTER = Pattern.compile("execution\\((.*)\\)(\\s+or\\s+execution\\((.*)\\))+");
}
