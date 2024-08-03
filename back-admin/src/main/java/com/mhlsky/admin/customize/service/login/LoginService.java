package com.mhlsky.admin.customize.service.login;

import com.mhlsky.admin.customize.service.login.dto.ConfigDTO;
import com.mhlsky.domain.common.cache.MapCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午7:19
 * @description
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    /**
     * 配置信息 data
     *
     * @return {@link ConfigDTO}
     */
    public ConfigDTO getConfig() {
        ConfigDTO configDTO = new ConfigDTO();

        // boolean isCaptchaOn = isCaptchaOn();
        boolean isCaptchaOn = false;

        configDTO.setIsCaptchaOn(isCaptchaOn);
        configDTO.setDictionary(MapCache.dictionaryCache());
        return configDTO;
    }





}
