package com.leon.adopen.common.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.leon.adopen.domain.exception.enums.AdopenDbCode;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 封装一层HTTP，捕获异常信息
 *
 * @author Leon
 * @date 2019/6/20
 */
@Slf4j
public class LeonHttpUtil {

    public static final String ERROR_RESULT = "time-out";
    public static String RESPONSE;
    public static String RESULT;

    /**
     * 简单的自定义HTTP请求 get
     *
     * @param url     请求地址
     * @param appId   入参appid
     * @param channel 渠道
     * @return 响应值
     * @throws AdopenDbException 入参空指针异常
     */
    public static String get(String url, String appId, String channel) throws AdopenDbException {
        try {
            RESULT = HttpUtil.get(url);
        } catch (Exception e) {
            log.error("http get error, appId:[{}], channel:[{}], url:[{}], message:[{}]", appId, channel, url, e.getMessage());
            return ERROR_RESULT;
        }
        return RESULT;
    }

    /**
     * 简单的自定义HTTP请求 post
     *
     * @param url     请求地址
     * @param appId   入参appid
     * @param channel 渠道
     * @return 响应值
     * @throws AdopenDbException 入参空指针异常
     */
    public static String post(String url, String appId, String channel) throws AdopenDbException {
        verifyParam(url, appId, channel);
        String result;
        try {
            result = HttpUtil.post(url, "");
        } catch (Exception e) {
            log.error("http get error, appId:[{}], channel:[{}], url:[{}], message:[{}]", appId, channel, url, e.getMessage());
            return ERROR_RESULT;
        }
        return result;
    }

    /**
     * 简单的自定义HTTP请求
     *
     * @param url     请求地址
     * @param appid   产品ID
     * @param channel 渠道号
     * @param data    表单数据
     * @return {@link   String} 响应值
     */
    public static String post(String url, String appid, String channel, Map<String, Object> data) {
        try {
            RESPONSE = HttpUtil.post(url, data);
        } catch (Exception e) {
            log.error("http post error, url:[{}], appid:[{}], channel:[{}], form data:[{}], message:[{}]", url, appid, channel, JSON.toJSONString(data), e.getMessage());
            return ERROR_RESULT;
        }
        return RESPONSE;
    }

    /**
     * 用于调本项目接口，查询产品限量
     *
     * @param url 请求地址
     * @return 响应信息, 限量值(整数)
     */
    public static String getLocalURL(String url) {
        String result;
        try {
            result = HttpUtil.get(url);
        } catch (Exception e) {
            log.error("http get error, check limit message:[{}]", e.getMessage());
            return ERROR_RESULT;
        }
        return result;
    }

    /**
     * 自定义HTTP Post请求
     *
     * @param url  请求地址
     * @param info 请求体信息
     * @return {@link  String} 响应内容
     */
    public static String post(String url, BaseInfo info) {
        String result;
        String jsonInfo = JSON.toJSONString(info);
        try {
            result = HttpUtil.post(url, jsonInfo);
        } catch (Exception e) {
            log.error("http post error, url:[{}], info:[{}], message:[{}]", url, jsonInfo, e.getMessage());
            return ERROR_RESULT;
        }
        return result;
    }

    /**
     * 自定义HTTP Post请求
     *
     * @param url 请求地址
     * @return {@link  String} 响应内容
     */
    public static String post(String url) {
        String result;
        try {
            result = HttpUtil.post(url, "");
        } catch (Exception e) {
            log.error("http post error, url:[{}], info:[{}], message:[{}]", url, "", e.getMessage());
            return ERROR_RESULT;
        }
        return result;
    }

    /**
     * 请求入参校验
     *
     * @param url     请求地址
     * @param appId   入参appid
     * @param channel 渠道
     * @throws AdopenDbException 入参空指针异常
     */
    private static void verifyParam(String url, String appId, String channel) throws AdopenDbException {
        if (StringUtils.isEmpty(url)) {
            throw new AdopenDbException(AdopenDbCode.lackData, "lack url");
        }
        if (StringUtils.isEmpty(appId)) {
            throw new AdopenDbException(AdopenDbCode.lackData, "lack app id");
        }
        if (StringUtils.isEmpty(channel)) {
            throw new AdopenDbException(AdopenDbCode.lackData, "lack channel");
        }
    }

}
