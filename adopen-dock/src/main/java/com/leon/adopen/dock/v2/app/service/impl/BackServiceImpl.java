package com.leon.adopen.dock.v2.app.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.leon.adopen.dock.v2.app.service.BackService;
import com.leon.adopen.domain.dao.AppCallbackLogDao;
import com.leon.adopen.domain.entity.AppCallbackLog;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leon
 * @date 2021-12-13 16:29
 */
@Service
@Slf4j
public class BackServiceImpl implements BackService {
    @Resource
    private AdopenCacheUtil cacheUtil;
    @Resource
    private AppCallbackLogDao callbackLogDao;

    private static final String STATUS_NONE = "wu";

    @Override
    public Object backToLeon(String appid, String idfa, String ip) throws AdopenDbException {
        log.info("-------------------回调数据-------------------");
        Map<String, Object> response = new HashMap<>(16);
        if (null == appid) {
            response.put("result", "sync info is null");
            log.info("[response to sp] -> {}", JSON.toJSONString(response));
            return response;
        }
        String result = STATUS_NONE;
        BaseInfo info = new BaseInfo(appid, idfa, ip);
        log.info("[sync info] -> {}", JSON.toJSON(info));
        if (!callbackLogDao.existsByAdAppIdAndIdfa(info.getAppId(), info.getIdfa())) {
            BaseInfo channelInfo = cacheUtil.takeChannelInfo(info);
            log.info("[channel info] -> {}", JSON.toJSON(channelInfo));
            if (null == channelInfo) {
                response.put("result", info.getAppId() + ":channel cache is null");
                log.info("[response to sp] -> {}", JSON.toJSONString(response));
                return response;
            }
            if (channelInfo.getCallback().isEmpty()) {
                response.put("result", info.getAppId() + ":channel callback url is null");
                log.info("[response to sp] -> {}" + JSON.toJSONString(response));
                return response;
            }
            String url = channelInfo.getCallback();
            log.info("[appid] -> {}, [channel url] -> {}", info.getAppId(), url);
            info.setCallback(url);
            result = HttpUtil.get(url);
            log.info("[request] -> {}, [response] -> {}, [idfa] ->{}", url, result, info.getIdfa());
//            info.setStatus(this.backScale(info));
//            if (url.equals(webApi + AppUrlConstants.ASSIST_LIMIT)) {
//                result = STATUS_OK;
//            } else if (info.getStatus().equals(STATUS_ONE)) {
//                result = HttpUtil.get(url);
//                if (result == null || result.equals(STATUS_EMPTY)) {
//                    result = HttpUtil.get(url);
//                }
//            }
            info.setStatus("1");
            AppCallbackLog backInfo = new AppCallbackLog();
            backInfo.setAdAppId(info.getAppId());
            backInfo.setIdfa(info.getIdfa());
            backInfo.setCallback(info.getCallback());
            backInfo.setResult(result);
            backInfo.setStatus(Byte.parseByte(info.getStatus()));
            backInfo.setInsertTime(new Date());
            callbackLogDao.save(backInfo);
            response.put("result", "ok");
            log.info("[response to sp] -> {}", JSON.toJSONString(response));
        } else {
            log.info("[this info exist] [appid] -> {}, [idfa] -> {}", info.getAppId(), info.getIdfa());
            response.put("result", "error");
            log.error("[response to sp] -> {}", JSON.toJSONString(response));
        }
        return response;
    }
//    private String backScale(BaseInfo info) throws AdopenDbException {
//        if (scaleManager.ifscale(Integer.parseInt(info.getAppId()))) {
//            scaleManager.update(AppScaleStatusConstants.STATUS_ONE, Integer.parseInt(info.getAppId()));
//            if (scaleManager.check(Integer.parseInt(info.getAppId()))) {
//                scaleManager.update(AppScaleStatusConstants.STATUS_ZERO, Integer.parseInt(info.getAppId()));
//                return STATUS_ZERO;
//            }
//        }
//        return STATUS_ONE;
//    }
}
