package com.geopark.framework.exception;

import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.model.ErrorCode;

/**
 * <p>
 * API 业务异常类
 * </p>
 *
 * @author lichee
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private final ErrorCode errorCode;

    public ApiException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.msg());
        this.errorCode = errorCodeEnum.convert();
    }

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getError());
        this.errorCode = errorCode;

    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
