package com.mhlsky.common.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/8/6 下午5:44
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity<T extends Model<?>> extends Model<T>{

    @Schema(defaultValue = "创建者ID")
    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    private Long creatorId;

    @Schema(defaultValue = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @Schema(defaultValue = "更新者ID")
    @TableField(value = "updater_id", fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.NOT_NULL)
    private Long updaterId;

    @Schema(defaultValue = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * deleted字段请在数据库中 设置为tinyInt   并且非null   默认值为0
     */
    @Schema(defaultValue = "删除标志（0代表存在 1代表删除）")
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;
}
