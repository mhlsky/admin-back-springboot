package com.mhlsky.domain.system.log.db;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * :系统访问记录
 *
 * @author mhlsky孟
 * @date 2024/8/8 下午4:14
 * @description
 */
@Getter
@Setter
@TableName("sys_login_info")
@Schema(defaultValue = "SysLoginInfoEntity对象", description = "系统访问记录")
public class SysLoginInfoEntity extends Model<SysLoginInfoEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "访问ID")
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    @Schema(defaultValue = "用户账号")
    @TableField("username")
    private String username;

    @Schema(defaultValue = "登录IP地址")
    @TableField("ip_address")
    private String ipAddress;

    @Schema(defaultValue = "登录地点")
    @TableField("login_location")
    private String loginLocation;

    @Schema(defaultValue = "浏览器类型")
    @TableField("browser")
    private String browser;

    @Schema(defaultValue = "操作系统")
    @TableField("operation_system")
    private String operationSystem;

    @Schema(defaultValue = "登录状态（1成功 0失败）")
    @TableField("`status`")
    private Integer status;

    @Schema(defaultValue = "提示消息")
    @TableField("msg")
    private String msg;

    @Schema(defaultValue = "访问时间")
    @TableField("login_time")
    private Date loginTime;

    @Schema(defaultValue = "逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;


    @Override
    public Serializable pkVal() {
        return this.infoId;
    }

}
