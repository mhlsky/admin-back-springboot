package com.mhlsky.admin.customize.service.login.dto;

import com.mhlsky.common.enums.dictionary.DictionaryData;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午6:28
 * @description
 */
@Data
public class ConfigDTO {
    private Boolean isCaptchaOn;

    private Map<String, List<DictionaryData>> dictionary;
}
