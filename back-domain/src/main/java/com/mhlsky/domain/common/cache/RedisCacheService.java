package com.mhlsky.domain.common.cache;

import cn.hutool.extra.spring.SpringUtil;
import com.mhlsky.infrastructure.cache.RedisUtil;
import com.mhlsky.infrastructure.cache.redis.CacheKeyEnum;
import com.mhlsky.infrastructure.cache.redis.RedisCacheTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/7 下午6:33
 * @description
 */
@Component
@RequiredArgsConstructor
public class RedisCacheService {
    private final RedisUtil redisUtil;

    public RedisCacheTemplate<String> captchaCache;


//    public RedisCacheTemplate<RoleInfo> roleModelInfoCache;

    @PostConstruct
    public void init() {

        captchaCache = new RedisCacheTemplate<>(redisUtil, CacheKeyEnum.CAPTCHAT);

        // loginUserCache = new RedisCacheTemplate<>(redisUtil, CacheKeyEnum.LOGIN_USER_KEY);

        // userCache = new RedisCacheTemplate<SysUserEntity>(redisUtil, CacheKeyEnum.USER_ENTITY_KEY) {
        //     @Override
        //     public SysUserEntity getObjectFromDb(Object id) {
        //         SysUserService userService = SpringUtil.getBean(SysUserService.class);
        //         return userService.getById((Serializable) id);
        //     }
        // };
        //
        // roleCache = new RedisCacheTemplate<SysRoleEntity>(redisUtil, CacheKeyEnum.ROLE_ENTITY_KEY) {
        //     @Override
        //     public SysRoleEntity getObjectFromDb(Object id) {
        //         SysRoleService roleService = SpringUtil.getBean(SysRoleService.class);
        //         return roleService.getById((Serializable) id);
        //     }
        // };

//        roleModelInfoCache = new RedisCacheTemplate<RoleInfo>(redisUtil, CacheKeyEnum.ROLE_MODEL_INFO_KEY) {
//            @Override
//            public RoleInfo getObjectFromDb(Object id) {
//                UserDetailsService userDetailsService = SpringUtil.getBean(UserDetailsService.class);
//                return userDetailsService.getRoleInfo((Long) id);
//            }
//
//        };

        // postCache = new RedisCacheTemplate<SysPostEntity>(redisUtil, CacheKeyEnum.POST_ENTITY_KEY) {
        //     @Override
        //     public SysPostEntity getObjectFromDb(Object id) {
        //         SysPostService postService = SpringUtil.getBean(SysPostService.class);
        //         return postService.getById((Serializable) id);
        //     }
        //
        // };


    }
}
