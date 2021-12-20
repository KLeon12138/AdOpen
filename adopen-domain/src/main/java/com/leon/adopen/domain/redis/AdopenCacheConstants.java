package com.leon.adopen.domain.redis;

/**
 * 缓存件KEY
 *
 * @author leon
 * @date 2021/11/25
 */
public class AdopenCacheConstants {
    public final static String KEY_HSET_CALLBACK = "hset:callback_url";
    public final static String KEY_MY_IDFA = "hset:my:idfa";
    public final static String KEY_CLICK = "hset:click";
    public final static String KEY_CLICK_APPID = "hset:click:appid";
    public static final String MESSAGE_KEY = "rdsmq:queue:";
}
