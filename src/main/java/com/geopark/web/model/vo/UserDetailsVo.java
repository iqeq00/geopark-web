package com.geopark.web.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 用户详情Vo
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDetailsVo {

    private static final long serialVersionUID = 1L;

    private String loginName;

    private String nickname;

    private String email;

    private String phone;

    private List<String> perms;

}
