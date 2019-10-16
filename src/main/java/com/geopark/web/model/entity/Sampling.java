package com.geopark.web.model.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 采样信息
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sampling")
public class Sampling implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    /**
     * 地质公园ID
     */
    @ExcelProperty(value = "公园编号",index = 1)
    private Integer parkId;

    /**
     * 样品编号
     */
    @ExcelProperty(value = "样品编号",index = 2)
    private String samplenumber;

    /**
     * 样品类型
     */
    @ExcelProperty(value = "样品类型",index = 3)
    private String sampletype;

    /**
     * 采样位置
     */
    @ExcelProperty(value = "采样位置",index = 4)
    private String sampleposition;

    /**
     * 坐标
     */
    @ExcelProperty(value = "坐标",index = 5)
    private String coordinate;

    /**
     * 地质代号
     */
    @ExcelProperty(value = "地质代号",index = 6)
    private String code;

    /**
     * 野外定名
     */
    @ExcelProperty(value = "野外定名",index = 7)
    private String research;

    /**
     * 测试成果
     */
    @ExcelProperty(value = "测试成果",index = 8)
    private String achievement;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 9)
    private String note;

    @ExcelIgnore
    private LocalDateTime createdAt;
    @ExcelIgnore
    private LocalDateTime updatedAt;
    @ExcelIgnore
    private LocalDateTime deletedAt;

}