package com.alan.validation;

import java.lang.annotation.*;

/**
 * author: alan.peng
 * description:
 * date: create in 17:20 2018/9/10
 * modified By：
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Constraint {
    public Class<? extends ConstraintValidator<?,?>>[] validateBy();
}
