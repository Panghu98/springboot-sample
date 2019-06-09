package com.example.demo.annotation;

import com.example.demo.enums.RoleEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dgh
 * @date 19-1-19 下午7:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleRequired {

    RoleEnum value() default RoleEnum.USER;

}
