package com.geopark.framework.annotations;

import java.lang.annotation.*;

/**
 * api操作 注解
 *
 * @author lichee
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiOperation {

    /**
     * api 接口描述
     */
    String value() default "未命名资源路径";
}
