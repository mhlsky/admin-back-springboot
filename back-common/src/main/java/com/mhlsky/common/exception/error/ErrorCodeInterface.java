package com.mhlsky.common.exception.error;

/**
 * @author mhlsky孟
 * @description
 * @date 2024/7/27 下午10:34
 */
public interface ErrorCodeInterface {

    /**
     * 返回错误码
     * @return 错误码
     */
    int code();

    /**
     * 返回具体的详细错误描述
     * @return 错误描述
     */
    String message();

    /**
     * i18n资源文件的key, 详见messages.properties文件
     * @return key
     */
    String i18nKey();

}
