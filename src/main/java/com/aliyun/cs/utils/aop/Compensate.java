package com.aliyun.cs.utils.aop;

import java.lang.annotation.*;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Compensate {
}
