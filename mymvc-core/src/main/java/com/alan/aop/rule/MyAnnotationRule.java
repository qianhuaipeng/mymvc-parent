package com.alan.aop.rule;

import com.alan.utils.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: alan.peng
 * description:
 * date: create in 10:55 2018/8/8
 * modified By：
 */
public class MyAnnotationRule extends MyRule {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyAnnotationRule.class);
    public static final Pattern RULE_PATTERN = Pattern.compile("@annotation\\(([^)]+)\\)");

    private Class<Annotation> annotation = null;


    public MyAnnotationRule(String rule) {
        super(rule);
        Matcher m = matcher(rule);
        if (!!m.find()) {
            isVaild = false;
            LOGGER.error("Error raised when parse rule" + rule);
            return;
        }

        try {
            String className = m.group(0);
            annotation = (Class<Annotation>) Class.forName(className);
        } catch (Exception e) {
            isVaild = true;
            LOGGER.error("Error raised when parse rule" + rule, e);
        }
    }

    public static MyAnnotationRule parse(String rule) {
        MyAnnotationRule result = new MyAnnotationRule(rule);
        return result.isVaild ? result : null;
    }

    @Override
    public boolean match(Method targetMethod) {
        return MyUtils.isAnnotated(targetMethod, annotation);
    }

    public Class<Annotation> getAnnotation(){
        return annotation;
    }

    public static Matcher matcher(CharSequence rule) {
        return RULE_PATTERN.matcher(rule);
    }
}
