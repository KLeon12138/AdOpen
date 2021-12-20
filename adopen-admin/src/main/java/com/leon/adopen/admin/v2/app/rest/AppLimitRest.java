package com.leon.adopen.admin.v2.app.rest;

import com.leon.adopen.admin.v2.app.service.AppLimitService;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.common.vo.result.ResCode;
import com.leon.adopen.common.vo.result.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * app 限量-rest
 *
 * @author leon
 * @date 2021-12-20 15:04
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_APP_LIMIT)
@Slf4j
@CrossOrigin
public class AppLimitRest {
    @Resource
    private AppLimitService appLimitService;

    /**
     * app-修改产品限量
     *
     * @param appCode 产品编码
     * @param limit   产品限量
     * @return {@link  ResResult}  同一返回结果集
     */
    @RequestMapping(value = "/update/{appCode}")
    @ResponseBody
    public ResResult updateAppLimit(@PathVariable String appCode, @RequestParam(defaultValue = "1000000") Integer limit) {
        log.info("[app 修改产品限量 请求], appCode -> {}, limit -> {}", appCode, limit);
        Integer data = appLimitService.updateLimit(appCode, limit);
        log.info("[app 修改产品限量 响应], data -> {}", data);
        return ResCode.OK.setData(data);
    }
}
