package com.geopark.web.model.vo;

import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.model.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户DTO
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserVo extends Convert {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String loginName;
    private String nickname;
    private String email;
    private String phone;
    private String ip;
    private StatusEnum status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<Integer> roleIds;
}
