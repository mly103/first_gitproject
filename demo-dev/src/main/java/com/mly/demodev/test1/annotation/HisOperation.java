package com.mly.demodev.test1.annotation;

import com.mly.demodev.test1.constant.OperationType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HisOperation {
    /**
     * 操作描述
     * @return
     */
    String value() default "";

    /**
     * 操作类型
     * @return
     */
    OperationType operationType();
}
