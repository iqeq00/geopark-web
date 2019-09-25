package com.geopark.web.model.entity;

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
 * 科普作品
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sciencework")
public class Sciencework implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园编号
     */
    private Integer parkId;

    /**
     * 作品编号
     */
    private String itemnumber;

    /**
     * 科普作品名称
     */
    private String scienceitem;

    /**
     * 受众群体
     */
    private String masses;

    /**
     * 作者
     */
    private String auther;

    /**
     * 完成时间
     */
    private String carrytime;

    /**
     * 完成单位
     */
    private String carryunit;

    /**
     * 是否出版
     */
    private String publishing;

    /**
     * 备注
     */
    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    /**
     * 存储地址
     */
    private String url;

}
