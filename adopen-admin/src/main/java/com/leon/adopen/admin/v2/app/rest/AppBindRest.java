package com.leon.adopen.admin.v2.app.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.v2.app.request.AppBindListRequest;
import com.leon.adopen.admin.v2.app.service.AppBindService;
import com.leon.adopen.admin.v2.app.vo.AppBindListVoPage;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.common.vo.result.ResCode;
import com.leon.adopen.common.vo.result.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-20 15:52
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_APP_BIND)
@Slf4j
@CrossOrigin
public class AppBindRest {
    @Resource
    private AppBindService appBindService;

    /**
     * 产品绑定列表
     *
     * @param request 产品绑定列表-request
     * @param page    分页信息
     * @return {@link  ResResult}  同一返回结果集
     */
    @PostMapping(value = "/list")
    public ResResult listAppBind(@RequestBody AppBindListRequest request, @RequestBody JsonPage<T> page) {
        log.info("[产品绑定列表 请求], request -> {}, page -> {}", JSON.toJSONString(request), JSON.toJSONString(page));
        AppBindListVoPage data = appBindService.listAppBind(request, page);
        log.info("[产品绑定列表 响应], data -> {}", data);
        return ResCode.OK.setData(data);
    }

    /**
     * app-修改产品绑定上线状态
     *
     * @param appCode 产品编码
     * @param sta     产品绑定上线状态
     * @return {@link  ResResult}  同一返回结果集
     */
    @RequestMapping(value = "/update/ison/{appCode}/{sta}")
    @ResponseBody
    public ResResult updateAppLimit(@PathVariable String appCode, @PathVariable Boolean sta) {
        log.info("[app 修改产品绑定上线状态 请求], appCode -> {}, sta -> {}", appCode, sta);
        Boolean data = appBindService.updateIsOn(appCode, sta);
        log.info("[app 修改产品绑定上线状态 响应], data -> {}", data);
        return ResCode.OK.setData(data);
    }
}
