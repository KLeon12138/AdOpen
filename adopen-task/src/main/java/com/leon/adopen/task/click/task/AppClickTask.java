package com.leon.adopen.task.click.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.domain.entity.AppClick;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.util.DateUtils;
import com.leon.adopen.task.click.service.AppClickTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品点击定时任务
 *
 * @author leon
 * @date 2021-12-22 16:08
 */
@Component
@Slf4j
@Validated
public class AppClickTask {
    @Resource
    private AppClickTaskService appClickTaskService;

    /**
     * 初始化点击
     * 每晚11点58分定时为第二天上量状态的产品添加一条点击，点击数置0
     * 可以为每条请求减少两次于数据库的交互
     *
     * @throws AdopenException 数据空异常
     */
    @Scheduled(cron = "0 58 23 * * ?")
    public void initClickCount() throws AdopenException {
        log.info("[定时任务初始化产品点击], now -> {}, yestday -> {}", DateUtil.now(), DateUtils.getSecondDay());
        List<AppClick> data = appClickTaskService.initClick(DateUtils.getSecondDay());
        log.info("[初始化产品点击成功], data:[{}]", JSON.toJSONString(data));
    }

    /**
     * 更新点击
     * 定时:每30分钟更新一次
     * 定时:每晚23:59:59更新最后一次
     *
     * @throws AdopenDbException 数据空异常
     */

    @Scheduled(fixedDelay = 30 * 60 * 1000)
    @Scheduled(cron = "59 59 23 * * ?")
    public void updateClick() throws AdopenDbException {
        log.info("--------------[更新点击]--------------");
        Object data = appClickTaskService.refreshClick("");
        log.info("[已更新的key], click keys:[{}]", JSON.toJSONString(data));
    }
}
