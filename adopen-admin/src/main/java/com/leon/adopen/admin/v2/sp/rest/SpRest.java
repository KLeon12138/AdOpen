package com.leon.adopen.admin.v2.sp.rest;

import com.alibaba.fastjson.JSON;
import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.sp.service.SpService;
import com.leon.adopen.admin.v2.sp.vo.SpListVoPage;
import com.leon.adopen.admin.v2.sp.vo.SpPullDownVo;
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
 * sp-rest
 *
 * @author leon
 * @date 2021-12-15 14:33
 */
@RestController
@RequestMapping(value = RouteConstants.ADMIN_PORT_SP)
@Slf4j
@CrossOrigin
public class SpRest {
    @Resource
    private SpService spService;

    /**
     * SP-列表
     *
     * @param requestBase 请求入参
     * @param page        分页信息
     * @return {@link  ResResult}  同一返回结果集
     */
    @PostMapping("/list")
    public ResResult listCp(@RequestBody RequestBase requestBase, @RequestBody JsonPage<T> page) {
        log.info("[SP 查询列表] 请求; request -> {}, page -> {}", JSON.toJSONString(requestBase), JSON.toJSONString(page));
        SpListVoPage data = spService.listSp(requestBase, page);
        log.info("[SP 查询列表] 响应; data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }

    /**
     * SP-新增
     *
     * @param requestBase 请求入参
     * @return {@link  ResResult}  同一返回结果集
     * @throws AdopenException 请求入参空异常或数据重复异常
     */
    @PostMapping("/save")
    public ResResult saveCp(@RequestBody RequestBase requestBase) throws AdopenException {
        log.info("[SP 添加上游] 请求; request -> {}", JSON.toJSONString(requestBase));
        spService.saveSp(requestBase);
        log.info("[SP 添加上游] 响应; 添加成功");
        return ResCode.OK;
    }

    /**
     * SP-下拉数据
     *
     * @return {@link  ResResult}  同一返回结果集
     */
    @PostMapping("/pulldown")
    public ResResult pullDownCp() {
        log.info("[SP 下拉数据] 请求");
        List<SpPullDownVo> data = spService.pullDownSp();
        log.info("[SP 下拉数据] 响应 data -> {}", JSON.toJSONString(data));
        return ResCode.OK.setData(data);
    }
}
