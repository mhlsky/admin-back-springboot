package com.mhlsky.admin.controller.common;

import cn.hutool.core.util.StrUtil;
import com.mhlsky.admin.customize.service.login.LoginService;
import com.mhlsky.admin.customize.service.login.dto.ConfigDTO;
import com.mhlsky.common.config.AdminBackConfig;
import com.mhlsky.common.core.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final LoginService loginService;


    /**
     * 访问首页，配置信息获取
     * @return 配置信息
     */
    @GetMapping("/")
    @Operation(summary = "首页")
    public String index() {
        return StrUtil.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。",
                adminBackConfig.getName(), adminBackConfig.getVersion());
    }
    /**
     * 获取系统的内置配置
     *
     * @return 配置信息
     */
    @GetMapping("/getConfig")
    @Operation(summary = "配置信息")
    public ResponseDTO<ConfigDTO> getConfig() {
        ConfigDTO configDTO = loginService.getConfig();
        System.out.println(configDTO);
        return ResponseDTO.ok(configDTO);

    }


}
