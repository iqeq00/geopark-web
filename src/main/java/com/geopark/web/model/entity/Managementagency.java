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
 * 管理机构
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("managementagency")
public class Managementagency implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 管理机构（科室）名称
     */
    private String managename;

    /**
     * 管理机构级别
     */
    private String level;

    /**
     * 主要负责人姓名
     */
    private String maincharge;

    /**
     * 次要负责人姓名
     */
    private String secondarycharge;

    /**
     * 负责人职务
     */
    private String job;

    /**
     * 管理机构设置人数
     */
    private String number;

    /**
     * 机构工作人员
     */
    private String list;

    /**
     * 机构职责与分工
     */
    private String responsibility;

    /**
     * 负责人联系电话
     */
    private String phone;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String MANAGENAME = "managename";

    public static final String LEVEL = "level";

    public static final String MAINCHARGE = "maincharge";

    public static final String SECONDARYCHARGE = "secondarycharge";

    public static final String JOB = "job";

    public static final String NUMBER = "number";

    public static final String LIST = "list";

    public static final String RESPONSIBILITY = "responsibility";

    public static final String PHONE = "phone";

}
