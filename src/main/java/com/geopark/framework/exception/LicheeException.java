package com.geopark.framework.exception;

/**
 * <p>
 * Crown异常类
 * </p>
 *
 * @author lichee
 */
public class LicheeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LicheeException(String message) {
        super(message);
    }

    public LicheeException(Throwable throwable) {
        super(throwable);
    }

    public LicheeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
