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
 * 相关科研论文
 * </p>
 *
 * @author lichee
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("researchpaper")
public class Researchpaper implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    /**
     * 地质公园编号
     */
    @ExcelProperty(value = "公园编号",index = 1)
    private Integer parkId;

    /**
     * 成果编号
     */
    @ExcelProperty(value = "成果编号",index = 2)
    private String achievementnumber;

    /**
     * 论文编号
     */
    @ExcelProperty(value = "论文编号",index = 3)
    private String papernumber;

    /**
     * 作者
     */
    @ExcelProperty(value = "作者",index = 4)
    private String author;

    /**
     * 年份
     */
    @ExcelProperty(value = "年份",index = 5)
    private String year;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称",index = 6)
    private String heading;

    /**
     * 期刊
     */
    @ExcelProperty(value = "期刊",index = 7)
    private String periodical;

    /**
     * 卷期
     */
    @ExcelProperty(value = "卷期",index = 8)
    private String volume;

    /**
     * 页码
     */
    @ExcelProperty(value = "页码",index = 9)
    private String pagenumber;

    /**
     * 摘要
     */
    @ExcelProperty(value = "摘要",index = 10)
    private String summary;

    /**
     * 收集情况
     */
    @ExcelProperty(value = "收集情况",index = 11)
    private String collect;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注",index = 12)
    private String note;

    /**
     * 存储地址
     */
    @ExcelProperty(value = "存储地址",index = 13)
    private String url;

}