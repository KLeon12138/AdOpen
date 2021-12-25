package com.leon.adopen.admin.v2.app.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.v2.app.request.AppListRequest;
import com.leon.adopen.admin.v2.app.request.AppSaveRequest;
import com.leon.adopen.admin.v2.app.service.AppService;
import com.leon.adopen.admin.v2.app.vo.AppListVoPage;
import com.leon.adopen.admin.v2.app.vo.AppPullDownVo;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.common.vo.result.ResCode;
import com.leon.adopen.common.vo.result.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * app-rest
 *
 * @author leon
 * @date 2021-12-16 11:44
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_APP)
@Slf4j
@CrossOrigin
public class AppRest {
    @Resource
    private AppService appService;

    /**
     * 产品列表
     *
     * @param request 产品请求数据
     * @param page    分页数据
     * @return {@link  ResResult}  同一处理结果集
     */
    @PostMapping("/list")
    public ResResult listApp(@RequestBody AppListRequest request, @RequestBody JsonPage<T> page) {
        log.info("[app 查询列表] 请求; request -> {}, page -> {}", JSON.toJSONString(request), JSON.toJSONString(page));
        AppListVoPage data = appService.listApp(request, page);
        log.info("[app 查询列表] 响应; data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }

    /**
     * 产品新增
     *
     * @param request 产品请求数据
     * @return {@link  ResResult}  同一处理结果集
     * @throws AdopenException 入参请求异常或数据重复异常
     */
    @PostMapping("/save")
    public ResResult saveApp(@RequestBody AppSaveRequest request) throws AdopenException {
        log.info("[app 新增] 请求; request -> {}", JSON.toJSONString(request));
        appService.saveApp(request);
        log.info("[app 新增] 响应; 新增完成");
        return ResCode.OK;
    }

    /**
     * APP-下拉数据
     *
     * @return {@link  ResResult}  同一返回结果集
     */
    @GetMapping("/pulldown")
    public ResResult pullDownCp() {
        log.info("[APP 下拉数据] 请求");
        List<AppPullDownVo> data = appService.pullDownApp();
        log.info("[APP 下拉数据] 响应 data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }
}
