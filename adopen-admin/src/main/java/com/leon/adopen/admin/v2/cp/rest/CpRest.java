package com.leon.adopen.admin.v2.cp.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.cp.service.CpService;
import com.leon.adopen.admin.v2.cp.vo.CpListVoPage;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.common.vo.result.ResCode;
import com.leon.adopen.common.vo.result.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * cp-rest
 *
 * @author leon
 * @date 2021-12-15 14:33
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_CP)
@Slf4j
@CrossOrigin
public class CpRest {
    @Resource
    private CpService cpService;

    /**
     * 渠道列表查询
     *
     * @param requestBase 请求入参
     * @param page        分页信息
     * @return {@link  ResResult}  同一返回结果集
     */
    @PostMapping("/list")
    public ResResult listCp(@RequestBody RequestBase requestBase, @RequestBody JsonPage<T> page) {
        log.info("[CP 查询列表] 请求; request -> {}, page -> {}", JSON.toJSONString(requestBase), JSON.toJSONString(page));
        CpListVoPage data = cpService.listCp(requestBase, page);
        log.info("[CP 查询列表] 响应; data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }

    /**
     * 渠道新增
     *
     * @param requestBase 请求入参
     * @return {@link  ResResult}  同一返回结果集
     * @throws AdopenException 请求入参空异常或数据重复异常
     */
    @PostMapping("/save")
    public ResResult saveCp(@RequestBody RequestBase requestBase) throws AdopenException {
        log.info("[CP 添加渠道] 请求; request -> {}", JSON.toJSONString(requestBase));
        cpService.saveCp(requestBase);
        log.info("[CP 添加渠道] 响应; 添加成功");
        return ResCode.OK;
    }
}
