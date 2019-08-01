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
 * 缔结姊妹公园
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("parkrelation")
public class Parkrelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 姊妹公园名称
     */
    private String parkName;

    /**
     * 地点
     */
    private String address;

    /**
     * 缔结时间
     */
    private String conclusionAt;

    /**
     * 双方代表
     */
    private String delegate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 照片
     */
    private String img;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String PARK_NAME = "park_name";

    public static final String ADDRESS = "address";

    public static final String CONCLUSION_AT = "conclusion_at";

    public static final String DELEGATE = "delegate";

    public static final String REMARK = "remark";

    public static final String IMG = "img";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
