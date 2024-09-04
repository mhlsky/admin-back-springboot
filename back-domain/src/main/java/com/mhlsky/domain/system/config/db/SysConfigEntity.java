package com.mhlsky.domain.system.config.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mhlsky.common.core.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/6 下午5:26
 * @description
 */
@Getter
@Setter
@TableName("sys_config")
@Schema(defaultValue = "SysConfigEntity对象", description = "参数配置表")
public class SysConfigEntity  extends BaseEntity<SysConfigEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "参数主键")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Integer configId;

    @Schema(defaultValue = "配置名称")
    @TableField("config_name")
    private String configName;

    @Schema(defaultValue = "配置键名")
    @TableField("config_key")
    private String configKey;

    @Schema(defaultValue = "可选的选项")
    @TableField("config_options")
    private String configOptions;

    @Schema(defaultValue = "配置值")
    @TableField("config_value")
    private String configValue;

    @Schema(defaultValue = "是否允许修改")
    @TableField("is_allow_change")
    private Boolean isAllowChange;

    @Schema(defaultValue = "备注")
    @TableField("remark")
    private String remark;


    @Override
    public Serializable pkVal() {
        return this.configId;
    }
}
