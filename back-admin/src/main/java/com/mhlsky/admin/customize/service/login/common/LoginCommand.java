package com.mhlsky.admin.customize.service.login.common;

import lombok.Data;

/**
 * :用户登录对象
 *
 * @author mhlsky孟
 * @date 2024/8/8 下午1:50
 * @description
 */
@Data
public class LoginCommand {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String captchaCode;

    /**
     * 唯一标识
     */
    private String captchaCodeKey;

}
