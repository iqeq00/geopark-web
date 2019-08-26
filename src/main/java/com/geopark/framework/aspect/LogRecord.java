package com.geopark.framework.aspect;

import com.geopark.framework.utils.LogUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Log Record
 *
 * @author lichee
 */
@Aspect
public class LogRecord {

    @Pointcut("execution(public * com.*.*.col.*Controller.*(..))")
    @SuppressWarnings("EmptyMethod")
    public void pointCut() {
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void doAfterReturning(Object ret) {

        LogUtils.doAfterReturning(ret);
    }

}
