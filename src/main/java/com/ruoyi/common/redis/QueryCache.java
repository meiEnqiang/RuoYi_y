package com.ruoyi.common.redis;

import java.lang.annotation.*;

/**
 * @author MeiEnQiang
 * @date 2018/9/20/0020
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface QueryCache {
    CacheNameSpace nameSpace();
}