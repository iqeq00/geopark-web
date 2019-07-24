package com.geopark.framework.utils;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.geopark.framework.cons.APICons;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.model.ErrorCode;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.responses.FailedResponse;
import com.geopark.framework.wrapper.ResponseWrapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

/**
 * response输出工具类
 *
 * @author Caratacus
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public abstract class ResponseUtils {

    /**
     * Portal输出json字符串
     *
     * @param response
     * @param obj      需要转换JSON的对象
     */
    public static void writeValAsJson(HttpServletRequest request, ResponseWrapper response, Object obj) {
        LogUtils.printLog((Long) request.getAttribute(APICons.API_BEGIN_TIME),
                TypeUtils.castToString(request.getAttribute(APICons.API_UID)),
                request.getParameterMap(),
                RequestUtils.getRequestBody(request),
                (String) request.getAttribute(APICons.API_REQURL),
                (String) request.getAttribute(APICons.API_MAPPING),
                (String) request.getAttribute(APICons.API_METHOD),
                IpUtils.getIpAddr(request),
                obj);
        if (ObjectUtils.isNotNull(response, obj)) {
            response.writeValueAsJson(obj);
        }
    }

    /**
     * 打印日志信息但是不输出到浏览器
     *
     * @param request
     * @param obj
     */
    public static void writeValAsJson(HttpServletRequest request, Object obj) {
        writeValAsJson(request, null, obj);
    }


    /**
     * 获取异常信息
     *
     * @param exception
     * @return
     */
    public static FailedResponse.FailedResponseBuilder exceptionMsg(FailedResponse.FailedResponseBuilder failedResponseBuilder, Exception exception) {
        if (exception instanceof MethodArgumentNotValidException) {
            StringBuilder builder = new StringBuilder("校验失败:");
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
            allErrors.stream().findFirst().ifPresent(error -> {
                builder.append(((FieldError) error).getField()).append("字段规则为").append(error.getDefaultMessage());
                failedResponseBuilder.msg(error.getDefaultMessage());
            });
            failedResponseBuilder.exception(builder.toString());
            return failedResponseBuilder;
        } else if (exception instanceof MissingServletRequestParameterException) {
            StringBuilder builder = new StringBuilder("参数字段");
            MissingServletRequestParameterException ex = (MissingServletRequestParameterException) exception;
            builder.append(ex.getParameterName());
            builder.append("校验不通过");
            failedResponseBuilder.exception(builder.toString()).msg(ex.getMessage());
            return failedResponseBuilder;
        } else if (exception instanceof MissingPathVariableException) {
            StringBuilder builder = new StringBuilder("路径字段");
            MissingPathVariableException ex = (MissingPathVariableException) exception;
            builder.append(ex.getVariableName());
            builder.append("校验不通过");
            failedResponseBuilder.exception(builder.toString()).msg(ex.getMessage());
            return failedResponseBuilder;
        } else if (exception instanceof ConstraintViolationException) {
            StringBuilder builder = new StringBuilder("方法.参数字段");
            ConstraintViolationException ex = (ConstraintViolationException) exception;
            Optional<ConstraintViolation<?>> first = ex.getConstraintViolations().stream().findFirst();
            if (first.isPresent()) {
                ConstraintViolation<?> constraintViolation = first.get();
                builder.append(constraintViolation.getPropertyPath().toString());
                builder.append("校验不通过");
                failedResponseBuilder.exception(builder.toString()).msg(constraintViolation.getMessage());
            }
            return failedResponseBuilder;
        }

        failedResponseBuilder.exception(TypeUtils.castToString(exception));
        return failedResponseBuilder;
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param code
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode code,
                                Exception exception) {
        ResponseUtils.writeValAsJson(request, getWrapper(response, code), ApiResponses.failure(code, exception));
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param code
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode code) {
        sendFail(request, response, code, null);
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param codeEnum
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCodeEnum codeEnum) {
        sendFail(request, response, codeEnum.convert(), null);
    }

    /**
     * 发送错误信息
     *
     * @param request
     * @param response
     * @param codeEnum
     * @param exception
     */
    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCodeEnum codeEnum,
                                Exception exception) {
        sendFail(request, response, codeEnum.convert(), exception);
    }

    /**
     * 获取Response
     *
     * @return
     */
    public static ResponseWrapper getWrapper(HttpServletResponse response, ErrorCode errorCode) {
        return new ResponseWrapper(response, errorCode);
    }
}
