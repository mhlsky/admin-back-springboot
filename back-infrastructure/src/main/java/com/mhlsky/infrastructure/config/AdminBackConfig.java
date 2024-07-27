package com.mhlsky.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mhlsky孟
 * @description 读取项目相关配置
 * @date 2024/7/27 下午10:14
 */
@Data
@Component
@ConfigurationProperties(prefix = "admin-back")
public class AdminBackConfig {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;
    /**
     * 实例演示开关
     */
    private static boolean demoEnabled;

    /**
     * 上传路径
     */
    private static String fileBaseDir;

    /**
     * 获取地址开关
     */
    private static boolean addressEnabled;

    /**
     * 验证码类型
     */
    private static String captchaType;

    /**
     * rsa private key  静态属性的注入！！ set方法一定不能是static 方法
     */
    private static String rsaPrivateKey;

    private static String apiPrefix;
    public static boolean isAddressEnabled() {
        return addressEnabled;
    }
    public static boolean isDemoEnabled() {
        return demoEnabled;
    }
}
