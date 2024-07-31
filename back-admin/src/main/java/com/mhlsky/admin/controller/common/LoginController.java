package com.mhlsky.admin.controller.common;

import cn.hutool.core.util.StrUtil;
import com.mhlsky.common.config.AdminBackConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author mhlsky孟
 * @date 2024/7/30 下午5:17
 * @description
 */
@Tag(name = "登录API", description = "登录相关接口")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private  final AdminBackConfig adminBackConfig;

    @GetMapping("/a")
    @Operation(summary = "接口")
    public String index() {
        return StrUtil.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。",
                adminBackConfig.getName(), adminBackConfig.getVersion());
    }
    @Operation(summary="接口1")
    @GetMapping("/hello")
    public String hello() {
        return  "hello";
    }

}
