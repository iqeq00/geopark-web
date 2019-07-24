package com.geopark.framework.responses;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 失败返回
 *
 * @author lichee
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class FailedResponse extends ApiResponses {

    private static final long serialVersionUID = 1L;
    /**
     * http 状态码
     */
    private Integer status;
    /**
     * 错误状态码
     */
    private String error;
    /**
     * 错误描述
     */
    private String msg;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 客户端是否展示
     */
    private Boolean show;
    /**
     * 当前时间戳
     */
    private LocalDateTime time;

}
