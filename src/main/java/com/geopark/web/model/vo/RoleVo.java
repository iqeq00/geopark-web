package com.geopark.web.model.vo;

import com.geopark.framework.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Caratacus
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String roleName;

    private String remark;

    private List<Integer> menuIds;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
