package com.leon.adopen.common.exception.example;

import com.leon.adopen.common.exception.code.ExCode;

/**
 * @author leon
 * @date 2021-11-29 16:58
 */
public class AdopenException extends Exception {
    private int errno;

    public AdopenException(int errno, String message) {
        super(message);
        this.errno = errno;
    }

    public AdopenException(String message) {
        super(message);
        this.errno = ExCode.fail.getErrno();
    }

    public AdopenException() {
    }

    public AdopenException(ExCode exCode, String message) {
        super(message);
        this.errno = exCode.getErrno();
    }

    public int getCode() {
        return errno;
    }

    public void setCode(int errno) {
        this.errno = errno;
    }
}
