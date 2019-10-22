package com.geopark.web.model.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 公园专家库与导游库
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("parklibrary")
public class Parklibrary implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 地质公园ID
     */
    @ExcelProperty(value = "地质公园ID",index = 0)
    private Integer parkId;

    /**
     * 编号
     */
    @ExcelProperty(value = "编号",index = 1)
    private String number;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名",index = 2)
    private String name;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别",index = 3)
    private String sex;

    /**
     * 出生年月
     */
    @ExcelProperty(value = "出生年月",index = 4)
    private String birth;

    /**
     * 学科方向
     */
    @ExcelProperty(value = "学科方向",index = 5)
    private String subjectDirection;

    /**
     * 聘用关系
     */
    @ExcelProperty(value = "聘用关系",index = 6)
    private String relationship;

    /**
     * 图片
     */
    @ExcelProperty(value = "图片",index = 7)
    private String img;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 8)
    private String remark;

    @ExcelIgnore
    private LocalDateTime createdAt;
    @ExcelIgnore
    private LocalDateTime updatedAt;
    @ExcelIgnore
    private LocalDateTime deletedAt;

}