package com.leon.adopen.common.exception.handler;

import com.leon.adopen.common.code.ResponseCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author leon
 * @date 2021-11-29 16:57
 */
@ControllerAdvice
@Slf4j
public class DefinedExceptionHandler {

    @ExceptionHandler(AdopenException.class)
    @ResponseBody
    public Object leonRespHandler(AdopenException e) {
        log.info("[捕获自定义异常 AdopenException] errno->{}, errmsg->{}", e.getCode(), e.getMessage());
        return ResponseCode.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(AdopenDbException.class)
    @ResponseBody
    public Object leonRespHandler(AdopenDbException e) {
        log.info("[捕获自定义异常 AdopenDbException] errno->{}, errmsg->{}", e.getCode(), e.getMessage());
        return ResponseCode.fail(e.getCode(), e.getMessage());
    }
}
