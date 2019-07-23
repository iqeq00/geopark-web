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
 * 博物馆基本情况
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("museum")
public class Museum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 博物馆名称
     */
    private String museumname;

    /**
     * 面积
     */
    private String area;

    /**
     * 建馆时间
     */
    private String buildtime;

    /**
     * 博物馆管理机构设置
     */
    private String museummechanism;

    /**
     * 博物馆分区与布展情况
     */
    private String museumpartition;

    /**
     * 馆藏展品概况
     */
    private String exhibitsoverview;

    /**
     * 地址
     */
    private String position;

    /**
     * 联系电话
     */
    private String contact;

    /**
     * E-MAIL
     */
    private String email;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String MUSEUMNAME = "museumname";

    public static final String AREA = "area";

    public static final String BUILDTIME = "buildtime";

    public static final String MUSEUMMECHANISM = "museummechanism";

    public static final String MUSEUMPARTITION = "museumpartition";

    public static final String EXHIBITSOVERVIEW = "exhibitsoverview";

    public static final String POSITION = "position";

    public static final String CONTACT = "contact";

    public static final String EMAIL = "email";

    public static final String NOTE = "note";

}
