package com.geopark.web.model.entity;

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
@Accessors(chain = true)
@TableName("researchpaper")
public class Researchpaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园编号
     */
    private Integer parkId;

    /**
     * 成果编号
     */
    private String achievementnumber;

    /**
     * 论文编号
     */
    private String papernumber;

    /**
     * 作者
     */
    private String author;

    /**
     * 年份
     */
    private String year;

    /**
     * 名称
     */
    private String heading;

    /**
     * 期刊
     */
    private String periodical;

    /**
     * 卷期
     */
    private String volume;

    /**
     * 页码
     */
    private String pagenumber;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 收集情况
     */
    private String collect;

    /**
     * 备注
     */
    private String note;

    /**
     * 存储地址
     */
    private String url;

}