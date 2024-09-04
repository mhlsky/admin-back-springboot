package com.mhlsky.domain.common.cache;

import com.mhlsky.domain.system.config.db.SysConfigService;
import com.mhlsky.infrastructure.cache.guava.AbstractGuavaCacheTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/6 下午3:13
 * @description
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GuavaCacheService {
    private final SysConfigService configService;

    public final AbstractGuavaCacheTemplate<String> configCache = new AbstractGuavaCacheTemplate<String>() {
        @Override
        public String getObjectFromDb(Object id) {
            return configService.getConfigValueByKey(id.toString());
        }
    };

/*     public final AbstractGuavaCacheTemplate<SysDeptEntity> deptCache = new AbstractGuavaCacheTemplate<SysDeptEntity>() {
        @Override
        public SysDeptEntity getObjectFromDb(Object id) {
            return deptService.getById(id.toString());
        }
    }; */

}
