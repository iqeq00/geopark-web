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
 * 公园信息管理
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("parkinfo")
public class Parkinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 法人代表
     */
    private String legalPerson;

    /**
     * 在任年限
     */
    private String tenure;

    /**
     * 公园安全责任人
     */
    private String securitySupervisor;

    /**
     * 安全责任人联
     */
    private String mobile;

    /**
     * 在编职工
     */
    private String staffer;

    /**
     * 公园网站地址
     */
    private String website;

    /**
     * 公园联系电话
     */
    private String contact;

    /**
     * 传真
     */
    private String fax;

    /**
     * 上级主管
     */
    private String supervisor;

    /**
     * 经费来源
     */
    private String fundProvider;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String ORG_CODE = "org_code";

    public static final String LEGAL_PERSON = "legal_person";

    public static final String TENURE = "tenure";

    public static final String SECURITY_SUPERVISOR = "security_supervisor";

    public static final String MOBILE = "mobile";

    public static final String STAFFER = "staffer";

    public static final String WEBSITE = "website";

    public static final String CONTACT = "contact";

    public static final String FAX = "fax";

    public static final String SUPERVISOR = "supervisor";

    public static final String FUND_PROVIDER = "fund_provider";

    public static final String MAIL = "mail";

    public static final String REMARK = "remark";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
