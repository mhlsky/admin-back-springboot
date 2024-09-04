package com.mhlsky.infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/7 下午1:27
 * @description
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableScheduling
@MapperScan(value = "com.mhlsky.**.db", markerInterface = com.baomidou.mybatisplus.core.mapper.BaseMapper.class)
public class ApplicationConfig {
}
