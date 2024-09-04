package com.mhlsky.domain.system.config.db;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * :参数配置表 服务类
 *
 * @author mhlsky孟
 * @date 2024/8/6 下午5:12
 * @description
 */
public interface SysConfigService  extends IService<SysConfigEntity> {
    /**
     * 通过key获取配置
     *
     * @param key 配置对应的key
     * @return 配置
     */
    String getConfigValueByKey(String key);
}
