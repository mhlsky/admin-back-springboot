package com.mhlsky.common.enums;

/**
 * :字典类型 接口
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午6:54
 * @description
 */
public interface DictionaryEnum<T> extends BasicEnum<T> {
    /**
     * 获取css标签
     * @return css标签
     */
    String cssTag();
}
