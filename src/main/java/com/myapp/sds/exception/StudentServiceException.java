package com.myapp.sds.exception;

public class StudentServiceException extends  Exception{


    public StudentServiceException() {
    }

    public StudentServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentServiceException(String message) {
        super(message);
    }

    public StudentServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StudentServiceException(Throwable cause) {
        super(cause);
    }
}
