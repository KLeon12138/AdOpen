package com.leon.adopen.domain.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leon.adopen.domain.exception.enums.AdopenDbCode;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import com.leon.adopen.domain.pojo.BaseInfo;
import com.leon.adopen.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缓存工具
 *
 * @author leon
 * @date 2019/5/2
 */
@Service
@Slf4j
public class AdopenCacheUtil {

    @Resource
    JedisUtil jedisUtil;


    public void saveInfo(BaseInfo info) {
        jedisUtil.hset(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + info.getChannel() + ":" + info.getIdfa(), JSON.toJSONString(info));
        jedisUtil.expire(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + info.getChannel() + ":" + info.getIdfa());
    }

    public void saveInfoNoMyIdfa(BaseInfo info) {
        jedisUtil.hset(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + info.getChannel() + ":" + info.getIdfa(), JSON.toJSONString(info));
    }

    public void saveMyIdfa(BaseInfo info) {
        jedisUtil.hset(AdopenCacheConstants.KEY_MY_IDFA + ":" + DateUtils.getShortNowNoChar() + ":" + info.getChannel() + ":" + info.getIdfa(), JSON.toJSONString(info));
        jedisUtil.expire(AdopenCacheConstants.KEY_MY_IDFA + ":" + DateUtils.getShortNowNoChar() + ":" + info.getChannel() + ":" + info.getIdfa());
    }

    public BaseInfo takeChannelInfo(BaseInfo info) throws AdopenDbException {
        return JSONObject.parseObject(jedisUtil.hget(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + info.getAppId() + ":" + info.getIdfa()), BaseInfo.class);
    }


    public long delFuzzyKey(String key) {
        return jedisUtil.hdel(key);
    }

    public BaseInfo takeInfoByChannelIdAndIDFA(String channelId, String idafa) throws AdopenDbException {
        BaseInfo newInfo = JSONObject.parseObject(jedisUtil.hget(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + channelId + ":" + idafa), BaseInfo.class);
        if (newInfo == null) {
            throw new AdopenDbException(AdopenDbCode.selectDataFailed, "channel:{}" + channelId + ", take new-info is null from redis");
        }
        return newInfo;
    }

    public String getData(String info) throws AdopenDbException {
        return jedisUtil.hget(info);
    }

    public Integer getFluxData(String info) {
        return jedisUtil.hgetFlux(info);
    }

    public List<String> takeDataByFuzzyKey(String key) throws AdopenDbException {
        return jedisUtil.hgetFuzzy(key);
    }

    public boolean isExsitKey(String key) {
        return jedisUtil.isExsit(key);
    }

    public long incr(String channel, String date) {
        return jedisUtil.incr(AdopenCacheConstants.KEY_CLICK + ":" + date + ":" + channel);
    }

    public long incrAppId(String appId, String date) {
        return jedisUtil.incr(AdopenCacheConstants.KEY_CLICK_APPID + ":" + date + ":" + appId);
    }

    public long getIncrByAppId(String appId, String date) throws AdopenDbException {
        return Long.parseLong(jedisUtil.hget(AdopenCacheConstants.KEY_CLICK_APPID + ":" + date + ":" + appId));
    }

    public void expire(BaseInfo info) {
        jedisUtil.expire(AdopenCacheConstants.KEY_HSET_CALLBACK + ":" + info.getChannel() + ":" + info.getIdfa());
    }

    public void expireMyIdfa(BaseInfo info) {
        jedisUtil.expire(AdopenCacheConstants.KEY_MY_IDFA + ":" + DateUtils.getShortNowNoChar() + ":" + info.getChannel() + ":" + info.getIdfa());
    }

    public void lpush(String key, String info) {
        jedisUtil.strSet(key, info);
        jedisUtil.expire(key);
    }

    public String lpop(String key) {
        return jedisUtil.strGet(key);
    }
}

