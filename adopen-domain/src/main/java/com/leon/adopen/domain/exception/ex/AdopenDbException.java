package com.leon.adopen.domain.exception.ex;


import com.leon.adopen.domain.exception.enums.AdopenDbCode;

public class AdopenDbException extends Exception {

    private int errno;

    public AdopenDbException(int errno, String message) {
        super(message);
        this.errno = errno;
    }

    public AdopenDbException(String message) {
        super(message);
        this.errno = -1;
    }

    public AdopenDbException() {
    }

    public AdopenDbException(AdopenDbCode code) {
        super(code.getErrmsg());
        this.errno = code.getErrno();
    }

    public AdopenDbException(AdopenDbCode code, String message) {
        super(message);
        this.errno = code.getErrno();
    }

    public int getCode() {
        return errno;
    }

    public void setCode(int errno) {
        this.errno = errno;
    }
}
