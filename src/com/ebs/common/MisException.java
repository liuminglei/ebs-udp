package com.ebs.common;

public class MisException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MisException(String msg) {
        super(msg);
    }

    public MisException(Throwable throwable) {
        super(throwable);
    }

    public MisException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
