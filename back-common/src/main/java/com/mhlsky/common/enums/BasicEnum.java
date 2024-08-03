package com.mhlsky.common.enums;

/**
 * :普通的枚举 接口
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午6:52
 * @description
 */
public interface BasicEnum<T> {
    /**
     * 获取枚举的值
     * @return 枚举值
     */
    T getValue();

    /**
     * 获取枚举的描述
     * @return 描述
     */
    String description();
}
