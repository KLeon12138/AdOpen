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
public class ClickCacheUtils {
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
        if (channel.equals(BindChannelConst.CHANNEL_1901)) {
            return AppClickConst.CLICK_1901 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1902)) {
            return AppClickConst.CLICK_1902 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1903)) {
            return AppClickConst.CLICK_1903 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1904)) {
            return AppClickConst.CLICK_1904 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1905)) {
            return AppClickConst.CLICK_1905 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1906)) {
            return AppClickConst.CLICK_1906 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1907)) {
            return AppClickConst.CLICK_1907 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_1908)) {
            return AppClickConst.CLICK_1908 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_2101)) {
            return AppClickConst.CLICK_2101 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_2102)) {
            return AppClickConst.CLICK_2102 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_2201)) {
            return AppClickConst.CLICK_2201 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        if (channel.equals(BindChannelConst.CHANNEL_2202)) {
            return AppClickConst.CLICK_2202 = cacheUtil.incr(channel, InitDateConstants.DATE_SHORT_TODAY);
        }
        return AppComConst.CLICK_CACHE;
    }
}
