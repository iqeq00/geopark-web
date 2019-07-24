package com.geopark.framework.utils;

import com.geopark.framework.spring.ApplicationUtils;
import com.geopark.web.model.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

/**
 * 请求日志工具类
 *
 * @author lichee
 */
@Slf4j
public abstract class LogUtils {

    /**
     * 获取日志对象
     *
     * @param beiginTime
     * @param parameterMap
     * @param requestBody
     * @param url
     * @param mapping
     * @param method
     * @param ip
     * @param object
     * @return
     */
    public static void printLog(Long beiginTime, String uid, Map<String, String[]> parameterMap, String requestBody, String url, String mapping, String method, String ip, Object object) {
        Log logInfo = Log.builder()
                //查询参数
                .parameterMap(parameterMap)
                .uid(uid)
                //请求体
                .requestBody(Optional.ofNullable(JacksonUtils.parse(requestBody)).orElse(requestBody))
                //请求路径
                .url(url)
                //请求mapping
                .mapping(mapping)
                //请求方法
                .method(method)
                .runTime((beiginTime != null ? System.currentTimeMillis() - beiginTime : 0) + "ms")
                .result(object)
                .ip(ip)
                .build();
        log.info(JacksonUtils.toJson(logInfo));
    }

    public static void doAfterReturning(Object ret) {
        ResponseUtils.writeValAsJson(ApplicationUtils.getRequest(), ret);
    }
}
