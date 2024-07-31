package com.mhlsky.common.utils.jackson;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/7/29 下午6:00
 * @description
 */
public class JacksonException extends  RuntimeException {
    public JacksonException(String message, Exception e) {
        super(message, e);
    }
}
