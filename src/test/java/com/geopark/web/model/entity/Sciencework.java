package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 科普作品
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
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


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String ITEMNUMBER = "itemnumber";

    public static final String SCIENCEITEM = "scienceitem";

    public static final String MASSES = "masses";

    public static final String AUTHER = "auther";

    public static final String CARRYTIME = "carrytime";

    public static final String CARRYUNIT = "carryunit";

    public static final String PUBLISHING = "publishing";

    public static final String NOTE = "note";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
