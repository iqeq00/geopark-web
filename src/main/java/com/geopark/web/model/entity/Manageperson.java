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
 * 管理人员
 * </p>
 *
 * @author lichee
 * @since 2019-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("manageperson")
public class Manageperson implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 管理机构ID
     */
    private Integer managementId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 出生年月
     */
    private String birth;

    /**
     * 毕业院校
     */
    private String college;

    /**
     * 专业
     */
    private String subject;

    /**
     * 学历学位
     */
    private String degree;

    /**
     * 职务职称
     */
    private String position;

    /**
     * 工作内容
     */
    private String job;

    /**
     * 照片
     */
    private String img;


}
