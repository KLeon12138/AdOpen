package com.leon.adopen.common.utils;

import com.leon.adopen.common.constants.app.AppClickConst;
import com.leon.adopen.common.constants.app.AppComConst;
import com.leon.adopen.common.constants.app.BindChannelConst;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.domain.redis.AdopenCacheUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 点击缓存记录
 *
 * @author leon
 * @date 2022-06-29 01:35
 */
@Service
public class CLickCacheUtils {
    @Resource
    private AdopenCacheUtil cacheUtil;

    public Long saveClick(String channel) {
        if (channel.equals(BindChannelConst.CHANNEL_1801)) {
            return AppClickConst.CLICK_1801 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1802)) {
            return AppClickConst.CLICK_1802 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1803)) {
            return AppClickConst.CLICK_1803 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1804)) {
            return AppClickConst.CLICK_1804 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1805)) {
            return AppClickConst.CLICK_1805 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1806)) {
            return AppClickConst.CLICK_1806 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1807)) {
            return AppClickConst.CLICK_1807 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        return AppComConst.CLICK_CACHE;
    }
}
