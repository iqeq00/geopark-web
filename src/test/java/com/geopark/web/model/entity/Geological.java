package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 地质背景
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("geological")
public class Geological implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 大地构造位置
     */
    private String position;

    /**
     * 地层
     */
    private String stratum;

    /**
     * 岩浆岩
     */
    private String magmatic;

    /**
     * 变质岩
     */
    private String metamorphic;

    /**
     * 地质构造
     */
    private String geostructure;

    /**
     * 矿产
     */
    private String mineral;

    /**
     * 地质发展演化
     */
    private String evolutionary;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String POSITION = "position";

    public static final String STRATUM = "stratum";

    public static final String MAGMATIC = "magmatic";

    public static final String METAMORPHIC = "metamorphic";

    public static final String GEOSTRUCTURE = "geostructure";

    public static final String MINERAL = "mineral";

    public static final String EVOLUTIONARY = "evolutionary";

}
