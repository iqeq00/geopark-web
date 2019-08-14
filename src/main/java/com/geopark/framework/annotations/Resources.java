package com.geopark.framework.annotations;

import com.geopark.framework.enums.AuthTypeEnum;

import java.lang.annotation.*;

/**
 * 权限认证 注解
 *
 * @author lichee
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resources {

    /**
     * 权限认证类型
     *
     * @see AuthTypeEnum
     */
    AuthTypeEnum value() default AuthTypeEnum.AUTH;

}