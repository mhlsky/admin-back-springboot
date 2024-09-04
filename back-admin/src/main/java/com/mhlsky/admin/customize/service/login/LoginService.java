package com.mhlsky.admin.customize.service.login;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import com.google.code.kaptcha.Producer;
import com.mhlsky.admin.customize.async.AsyncTaskFactory;
import com.mhlsky.admin.customize.service.login.common.LoginCommand;
import com.mhlsky.admin.customize.service.login.dto.CaptchaDTO;
import com.mhlsky.admin.customize.service.login.dto.ConfigDTO;
import com.mhlsky.common.config.AdminBackConfig;
import com.mhlsky.common.constant.Constants;
import com.mhlsky.common.enums.common.ConfigKeyEnum;
import com.mhlsky.common.enums.common.LoginStatusEnum;
import com.mhlsky.common.exception.ApiException;
import com.mhlsky.common.exception.error.ErrorCode;
import com.mhlsky.domain.common.cache.GuavaCacheService;
import com.mhlsky.domain.common.cache.MapCache;
import com.mhlsky.domain.common.cache.RedisCacheService;
import com.mhlsky.infrastructure.thread.ThreadPoolManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;

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

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    private final RedisCacheService redisCache;
    private final GuavaCacheService guavaCache;


    /**
     * 配置信息 data
     *
     * @return {@link ConfigDTO}
     */
    public ConfigDTO getConfig() {
        ConfigDTO configDTO = new ConfigDTO();

        boolean isCaptchaOn = isCaptchaOn();
        // boolean isCaptchaOn = false;
        // System.out.println("isCaptchaOn = " + isCaptchaOn);
        configDTO.setIsCaptchaOn(isCaptchaOn);
        configDTO.setDictionary(MapCache.dictionaryCache());
        return configDTO;
    }

    /**
     * 获取验证码 data
     *
     * @return 验证码
     */
    public CaptchaDTO generateCaptchaImg() {
        CaptchaDTO captchaDTO = new CaptchaDTO();

        boolean isCaptchaOn = isCaptchaOn();
        captchaDTO.setIsCaptchaOn(isCaptchaOn);

        if (isCaptchaOn) {
            String expression;
            String answer = null;
            BufferedImage image = null;

            // 生成验证码
            String captchaType = AdminBackConfig.getCaptchaType();
            if (Constants.Captcha.MATH_TYPE.equals(captchaType)) {
                String capText = captchaProducerMath.createText();
                String[] expressionAndAnswer = capText.split("@");
                expression = expressionAndAnswer[0];
                answer = expressionAndAnswer[1];
                image = captchaProducerMath.createImage(expression);
            }

            if (Constants.Captcha.CHAR_TYPE.equals(captchaType)) {
                expression = answer = captchaProducer.createText();
                image = captchaProducer.createImage(expression);
            }

            if (image == null) {
                throw new ApiException(ErrorCode.Internal.LOGIN_CAPTCHA_GENERATE_FAIL);
            }

            // 保存验证码信息
            String imgKey = IdUtil.simpleUUID();

            redisCache.captchaCache.set(imgKey, answer);
            // 转换流信息写出
            FastByteArrayOutputStream os = new FastByteArrayOutputStream();
            ImgUtil.writeJpg(image, os);
            captchaDTO.setCaptchaCodeKey(imgKey);
            captchaDTO.setCaptchaCodeImg(Base64.encode(os.toByteArray()));

        }

        return captchaDTO;
    }

    private boolean isCaptchaOn() {
        return Convert.toBool(guavaCache.configCache.get(ConfigKeyEnum.CAPTCHA.getValue()));
    }

}
