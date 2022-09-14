package com.agoni.mybatis.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author AgoniMou
 * @since 2022-09-14
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", hidden = true)
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;
}
