package com.mhlsky.common.enums.dictionary;

import java.lang.annotation.*;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午7:12
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dictionary {
    /**
     * 字典类型名称
     */
    String name() default "";
}
