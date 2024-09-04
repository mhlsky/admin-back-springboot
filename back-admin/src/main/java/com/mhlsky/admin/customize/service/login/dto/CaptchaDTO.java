package com.mhlsky.admin.customize.service.login.dto;

import lombok.Data;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/6 下午2:41
 * @description
 */
@Data
public class CaptchaDTO {
    private Boolean isCaptchaOn;
    private String captchaCodeKey;
    private String captchaCodeImg;
}
