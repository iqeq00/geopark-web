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
 * 自然景观
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("naturallandscape")
public class Naturallandscape implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 自然景观编号
     */
    private String naturalnumber;

    /**
     * 景观名称
     */
    private String nname;

    /**
     * 地理位置
     */
    private String position;

    /**
     * 交通状况
     */
    private String traffic;

    /**
     * 经度
     */
    private Double lat;

    /**
     * 纬度
     */
    private Double lng;

    /**
     * 海拔高度
     */
    private String altitude;

    /**
     * 景观特色
     */
    private String feature;

    /**
     * 文物保护单位
     */
    private String level;

    /**
     * 批准时间
     */
    private String approvedtime;

    /**
     * 保护现状
     */
    private String status;

    /**
     * 照片
     */
    private String img;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
