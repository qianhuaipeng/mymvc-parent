package com.alan.web.bind.annotation;

import java.lang.annotation.*;

/**
 * author: alan.peng
 * description:
 * date: create in 16:38 2018/9/10
 * modified By：
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CookieValue {

    String value() default "";

    boolean requied() default true;

    String defaultValue() default ValueConstants.DEFAULT_NONE;
}
