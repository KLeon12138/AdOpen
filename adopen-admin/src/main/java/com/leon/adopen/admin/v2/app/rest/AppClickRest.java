package com.leon.adopen.admin.v2.app.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.v2.app.request.AppClickRequest;
import com.leon.adopen.admin.v2.app.service.AppClickService;
import com.leon.adopen.admin.v2.app.vo.AppClickListVoPage;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.common.vo.result.ResCode;
import com.leon.adopen.common.vo.result.ResResult;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author leon
 * @date 2021-12-26 22:04
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_APP_CLICK)
@Slf4j
@CrossOrigin
public class AppClickRest {
    @Resource
    private AppClickService appClickService;

    /**
     * 产品列表
     *
     * @param request 产品请求数据
     * @param page    分页数据
     * @return {@link  ResResult}  同一处理结果集
     */
    @PostMapping("/list")
    public ResResult listApp(@RequestBody AppClickRequest request, @RequestBody JsonPage<T> page) {
        log.info("[产品点击 查询列表] 请求; request -> {}, page -> {}", JSON.toJSONString(request), JSON.toJSONString(page));
        AppClickListVoPage data = appClickService.listClick(request, page);
        log.info("[产品点击 查询列表] 响应; data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }

    /**
     * 刷新产品点击
     *
     * @throws AdopenDbException 缓存失效、更新失败等异常
     */
    @GetMapping("/refresh")
    public ResResult refresh() throws AdopenDbException {
        log.info("[产品点击 刷新] 请求; 刷新日期 -> {}", InitDateConstants.DATE_SHORT_TODAY);
        appClickService.refresh(InitDateConstants.DATE_SHORT_TODAY);
        log.info("[产品点击 刷新] 响应; 刷新成功");
        return ResCode.OK;
    }
}
