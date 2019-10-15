package com.geopark.web.model.entity;

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
 * 地质遗迹景观
 * </p>
 *
 * @author lichee
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("geolandscape")
public class Geolandscape implements Serializable {

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
     * 地质遗迹统一编号
     */
    @ExcelProperty(value = "统一编号",index = 2)
    private String unitenumber;

    /**
     * 原编号
     */
    @ExcelProperty(value = "原编号",index = 3)
    private String originalnumber;

    /**
     * 地质遗迹名称
     */
    @ExcelProperty(value = "地质遗迹名称",index = 4)
    private String gname;

    /**
     * 地质遗迹原名称
     */
    @ExcelProperty(value = "原名称",index = 5)
    private String originalname;

    /**
     * 地质遗迹类型
     */
    @ExcelProperty(value = "遗迹类型",index = 6)
    private String type;

    /**
     * 地质遗迹地理位置
     */
    @ExcelProperty(value = "地理位置",index = 7)
    private String position;

    /**
     * 地质遗迹交通状况
     */
    @ExcelProperty(value = "交通状况",index = 8)
    private String traffic;

    /**
     * 经度
     */
    @ExcelProperty(value = "经度",index = 9)
    private String lat;

    /**
     * 纬度
     */
    @ExcelProperty(value = "纬度",index = 10)
    private String lng;

    /**
     * 海拔高度
     */
    @ExcelProperty(value = "海拔高度",index = 11)
    private String altitude;

    /**
     * 地质遗迹地质背景
     */
    @ExcelProperty(value = "地质背景",index = 12)
    private String background;

    /**
     * 地质遗迹特征
     */
    @ExcelProperty(value = "遗迹特征",index = 13)
    private String feature;

    /**
     * 评价级别
     */
    @ExcelProperty(value = "评价级别",index = 14)
    private String evaluation;

    /**
     * 保护级别
     */
    @ExcelProperty(value = "保护级别",index = 15)
    private String protection;

    /**
     * 观赏价值
     */
    @ExcelProperty(value = "观赏价值",index = 16)
    private String value;

    /**
     * 遗迹成因类型
     */
    @ExcelProperty(value = "成因类型",index = 17)
    private String causes;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 18)
    private String note;

    /**
     * 照片
     */
    @ExcelProperty(value = "照片",index = 19)
    private String img;

}