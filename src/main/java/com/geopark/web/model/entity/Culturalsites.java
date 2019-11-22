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
 * 文物保护单位
 * </p>
 *
 * @author lichee
 * @since 2019-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("culturalsites")
public class Culturalsites implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 文物保护单位名称
     */
    private String sitename;

    /**
     * 公布批次
     */
    private String batch;

    /**
     * 年代
     */
    private String dates;

    /**
     * 类别
     */
    private String type;

    /**
     * 地址
     */
    private String address;

    /**
     * 保护级别
     */
    private String level;

    /**
     * 含文物点数量
     */
    private String number;


}
