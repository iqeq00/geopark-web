package com.geopark.framework.model;

import lombok.*;

/**
 * 业务异常类
 *
 * @author lichee
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ErrorCode {

    /**
     * 错误
     */
    private String error;
    /**
     * http状态码
     */
    private int httpCode;
    /**
     * 是否展示
     */
    private boolean show;
    /**
     * 错误消息
     */
    private String msg;

}
