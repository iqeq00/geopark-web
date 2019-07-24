package com.geopark.framework.responses;

import lombok.*;

/**
 * 成功返回
 *
 * @author lichee
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponses<T> extends ApiResponses<T> {

    private static final long serialVersionUID = 1L;
    /**
     * http 状态码
     */
    private Integer status;
    /**
     * 结果集返回
     */
    private T result;

}
