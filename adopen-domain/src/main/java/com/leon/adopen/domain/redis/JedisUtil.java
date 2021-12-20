package com.leon.adopen.domain.redis;

import com.leon.adopen.domain.exception.enums.AdopenDbCode;
import com.leon.adopen.domain.exception.ex.AdopenDbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 操作Reids
 *
 * @author leon
 * @date 2021/11/25
 */
@Slf4j
@Service
public class JedisUtil {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static final Integer DEFAULT_FLUX = 1;

    public void hset(String key, String vaule) {
        try {
            stringRedisTemplate.opsForValue().set(key, vaule);
        } catch (Exception e) {
            log.error("redis set key error:{}", e.getMessage());
        }
    }

    public boolean isExsit(String key) {
        String data = stringRedisTemplate.opsForValue().get(key);
        return data != null;
    }

    public String hget(String key) throws AdopenDbException {
        String data = stringRedisTemplate.opsForValue().get(key);
        if (data == null) {
            log.error("[redis data is null] key -> {}", key);
            throw new AdopenDbException(AdopenDbCode.selectDataFailed, key + ":take data is null from redis");
        }
        return data;
    }

    public Integer hgetFlux(String key) {
        BoundValueOperations<String, String> info = stringRedisTemplate.boundValueOps(key);
        Long data = stringRedisTemplate.boundValueOps(key).size();
        if (data == null) {
            return DEFAULT_FLUX;
        }
        return data.intValue();
    }

    public List<String> hgetFuzzy(String key) throws AdopenDbException {
        Set<String> fuzzyKeys = stringRedisTemplate.keys(key + "*");
        if (fuzzyKeys == null) {
            throw new AdopenDbException(AdopenDbCode.selectDataFailed, key + ":fuzzy key is null form redis");
        }
        return new ArrayList<>(fuzzyKeys);
    }

    public long hdel(String key) {
        return stringRedisTemplate.delete(stringRedisTemplate.keys(key + "*"));
    }

    public Long incr(String key) {
        Long incr = null;
        try {
            incr = stringRedisTemplate.opsForValue().increment(key, 1);
        } catch (Exception e) {
            log.error("redis incr key error, key:[{}], message:[{}]", key, e.getMessage());
        }
        return incr;
    }

    public void expire(String key) {
        try {
            stringRedisTemplate.expire(key, 1, TimeUnit.DAYS);
        } catch (Exception e) {
            log.error("redis expire key error, key:[{}], message:[{}]", key, e.getMessage());
        }
    }

    public void push(String key, String message) {
        stringRedisTemplate.opsForList().leftPush(key, message);
    }

    public String pop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    public void strSet(String key, String vaule) {
        stringRedisTemplate.opsForValue().set(key, vaule);
    }

    public String strGet(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
