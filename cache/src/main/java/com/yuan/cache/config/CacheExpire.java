package com.yuan.cache.config;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: CacheExpire
 * @author: hansiyuan
 * @date: 2022/5/22 10:05 PM
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheExpire {

    int value() default -1;

    /**
     * 过期时间 秒
     */
    @AliasFor("value")
    int expire() default -1;
}
