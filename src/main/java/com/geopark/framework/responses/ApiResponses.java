package com.geopark.framework.responses;

import com.geopark.framework.model.ErrorCode;
import com.geopark.framework.utils.ResponseUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * GET: 200 OK
 * POST: 201 Created
 * PUT: 200 OK
 * PATCH: 200 OK
 * DELETE: 204 No Content
 * 接口返回(多态)
 *
 * @author lichee
 */
public class ApiResponses<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 不需要返回结果
     *
     * @param status
     */
    public static ApiResponses<Void> success(HttpServletResponse response, HttpStatus status) {
        response.setStatus(status.value());
        return SuccessResponses.<Void>builder().status(status.value()).build();

    }

    /**
     * 成功返回
     *
     * @param object
     */
    public static <T> ApiResponses<T> success(HttpServletResponse response, T object) {
        return success(response, HttpStatus.OK, object);

    }

    /**
     * 成功返回
     *
     * @param status
     * @param object
     */
    public static <T> ApiResponses<T> success(HttpServletResponse response, HttpStatus status, T object) {
        response.setStatus(status.value());
        return SuccessResponses.<T>builder().status(status.value()).result(object).build();

    }

    /**
     * 失败返回
     *
     * @param errorCode
     * @param exception
     */
    public static <T> ApiResponses<T> failure(ErrorCode errorCode, Exception exception) {
        return ResponseUtils.exceptionMsg(FailedResponse.builder().msg(errorCode.getMsg()), exception)
                .error(errorCode.getError())
                .show(errorCode.isShow())
                .time(LocalDateTime.now())
                .status(errorCode.getHttpCode())
                .build();
    }

}
