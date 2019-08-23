package com.geopark.framework.aspect;

import com.geopark.framework.utils.LogUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Controller统一切点日志处理
 *
 * @author lichee
 */
@Aspect
public class LogRecordAspect {

    @Pointcut("execution(public * com.*.*.col.*Controller.*(..))")
    @SuppressWarnings("EmptyMethod")
    public void pointCut() {
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) {

        LogUtils.doAfterReturning(ret);
    }

}
