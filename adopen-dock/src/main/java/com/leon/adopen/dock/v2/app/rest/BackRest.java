package com.leon.adopen.dock.v2.app.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.dock.v2.app.service.BackService;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 官方请求我方 回调接口
 *
 * @author leon
 * @date 2019/05/02
 */
@RestController
@RequestMapping("/back")
@Validated
@Slf4j
@CrossOrigin
public class BackRest {
    @Resource
    private BackService backService;

    @GetMapping("/to/leon")
    public Object callbackChannel(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip) throws AdopenDbException {
        log.info("[callback request] [appid] -> {}, idfa -> {}, ip -> {}", appid, idfa, ip);
        Object clickResponse = backService.backToLeon(appid, idfa, ip);
        log.info("[callback response] -> {}", JSON.toJSON(clickResponse));
        return clickResponse;
    }
}
