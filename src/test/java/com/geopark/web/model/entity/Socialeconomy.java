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
 * 社会经济概况
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("socialeconomy")
public class Socialeconomy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer parkId;

    /**
     * 公园内人口民族情况
     */
    private String ethnic;

    /**
     * 公园所在区域人口民族情况
     */
    private String areaethnic;

    /**
     * 公园内经济发展情况
     */
    private String economic;

    /**
     * 公园所在区域
     */
    private String areaeconomic;

    /**
     * 经济发展情况公园对于社区及区域经济可持续发展的贡献情况
     */
    private String develop;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String ETHNIC = "ethnic";

    public static final String AREAETHNIC = "areaethnic";

    public static final String ECONOMIC = "economic";

    public static final String AREAECONOMIC = "areaeconomic";

    public static final String DEVELOP = "develop";

    public static final String NOTE = "note";

}
