package com.ulovecode.modules.annotation;

import java.lang.annotation.*;



@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ContollerLog {
    String messgae()  default "";
    String methods()  default "";
}