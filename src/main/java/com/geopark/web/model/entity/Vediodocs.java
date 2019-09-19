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
 * 影像资料
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("vediodocs")
public class Vediodocs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 文件编号
     */
    private String number;

    /**
     * 文件名称
     */
    private String docname;

    /**
     * 发布时间
     */
    private String publishtime;

    /**
     * 发布单位
     */
    private String unit;

    /**
     * 存储地址
     */
    private String url;

    /**
     * 文件描述
     */
    private String desc;


}
