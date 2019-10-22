package com.geopark.web.model.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 地灾信息
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("earthquake")
public class Earthquake implements Serializable {

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
     * 灾害点编号
     */
    @ExcelProperty(value = "灾害点编号",index = 1)
    private String disasternumber;

    /**
     * 灾害点名称
     */
    @ExcelProperty(value = "灾害点名称",index = 2)
    private String disastername;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型",index = 3)
    private String type;

    /**
     * 地理位置
     */
    @ExcelProperty(value = "地理位置",index = 4)
    private String position;

    /**
     * 坐标
     */
    @ExcelProperty(value = "坐标",index = 5)
    private String coordinate;

    /**
     * 规模
     */
    @ExcelProperty(value = "规模",index = 6)
    private String scale;

    /**
     * 稳定性
     */
    @ExcelProperty(value = "稳定性",index = 7)
    private String stability;

    /**
     * 危险性
     */
    @ExcelProperty(value = "危险性",index = 8)
    private String dangerous;

    /**
     * 特征描述
     */
    @ExcelProperty(value = "特征描述",index = 9)
    private String description;

    /**
     * 诱发因素
     */
    @ExcelProperty(value = "诱发因素",index = 10)
    private String factor;

    /**
     * 威胁对象
     */
    @ExcelProperty(value = "威胁对象",index = 11)
    private String threat;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 12)
    private String note;

}