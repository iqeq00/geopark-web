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
 * 自然景观
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("naturallandscape")
public class Naturallandscape implements Serializable {

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
     * 自然景观编号
     */
    @ExcelProperty(value = "自然景观编号",index = 1)
    private String naturalnumber;

    /**
     * 景观名称
     */
    @ExcelProperty(value = "景观名称",index = 2)
    private String nname;

    /**
     * 地理位置
     */
    @ExcelProperty(value = "地理位置",index = 3)
    private String position;

    /**
     * 交通状况
     */
    @ExcelProperty(value = "交通状况",index = 4)
    private String traffic;

    /**
     * 经度
     */
    @ExcelProperty(value = "经度",index = 5)
    private String lat;

    /**
     * 纬度
     */
    @ExcelProperty(value = "纬度",index = 6)
    private String lng;

    /**
     * 海拔高度
     */
    @ExcelProperty(value = "海拔高度",index = 7)
    private String altitude;

    /**
     * 景观特色
     */
    @ExcelProperty(value = "景观特色",index = 8)
    private String feature;

    /**
     * 文物保护单位
     */
    @ExcelProperty(value = "文物保护单位",index = 9)
    private String level;

    /**
     * 批准时间
     */
    @ExcelProperty(value = "批准时间",index = 10)
    private String approvedtime;

    /**
     * 保护现状
     */
    @ExcelProperty(value = "保护现状",index = 11)
    private String status;

    /**
     * 照片
     */
    @ExcelProperty(value = "照片",index = 12)
    private String img;

    @ExcelIgnore
    private LocalDateTime createdAt;
    @ExcelIgnore
    private LocalDateTime updatedAt;
    @ExcelIgnore
    private LocalDateTime deletedAt;


}
