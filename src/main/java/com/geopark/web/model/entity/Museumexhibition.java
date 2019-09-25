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
 * 博物馆展厅
 * </p>
 *
 * @author lichee
 * @since 2019-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("museumexhibition")
public class Museumexhibition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 博物馆编号
     */
    private String museumid;

    /**
     * 博物馆名称
     */
    private String museumname;

    /**
     * 展厅编号
     */
    private String number;

    /**
     * 展厅名称
     */
    private String exhibitionname;

    /**
     * 公共服务设施情况
     */
    private String facilities;

    /**
     * 图片地址
     */
    private String img;

    /**
     * 展厅描述
     */
    private String exhibitiondesc;


}
