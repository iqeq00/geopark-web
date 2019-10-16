package com.geopark.web.model.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 游客统计
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gueststat")
public class Gueststat implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    /**
     * 地质公园ID
     */
    @ExcelProperty(value = "地质公园ID",index = 1)
    private Integer parkId;

    /**
     * 时间
     */
    @ExcelProperty(value = "时间",index = 2)
    private String time;

    /**
     * 游客人数 单位
     */
    @ExcelProperty(value = "游客人数 单位",index = 3)
    private Double touristsnumber;

    /**
     * 游客来源
     */
    @ExcelProperty(value = "游客来源",index = 4)
    private String touristssource;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 5)
    private String note;

    @TableField(fill = FieldFill.INSERT)
    @ExcelIgnore
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ExcelIgnore
    private LocalDateTime updateTime;

    @ExcelIgnore
    private LocalDateTime deletedAt;

}