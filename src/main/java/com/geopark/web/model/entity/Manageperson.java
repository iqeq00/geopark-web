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

/**
 * <p>
 * 管理人员
 * </p>
 *
 * @author lichee
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manageperson")
public class Manageperson implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    /**
     * 管理机构ID
     */
    @ExcelProperty(value = "管理机构ID",index = 1)
    private Integer managementId;

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
     * 民族
     */
    @ExcelProperty(value = "民族",index = 4)
    private String nation;

    /**
     * 出生年月
     */
    @ExcelProperty(value = "出生年月",index = 5)
    private String birth;

    /**
     * 毕业院校
     */
    @ExcelProperty(value = "毕业院校",index = 6)
    private String college;

    /**
     * 专业
     */
    @ExcelProperty(value = "专业",index = 7)
    private String subject;

    /**
     * 学历学位
     */
    @ExcelProperty(value = "学历学位",index = 8)
    private String degree;

    /**
     * 职务职称
     */
    @ExcelProperty(value = "职务职称",index = 9)
    private String position;

    /**
     * 工作内容
     */
    @ExcelProperty(value = "工作内容",index = 10)
    private String job;

    /**
     * 照片
     */
    @ExcelProperty(value = "照片",index = 11)
    private String img;


}
