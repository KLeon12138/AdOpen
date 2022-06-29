package com.leon.adopen.dock.v2.app.service;

import com.leon.adopen.domain.exception.ex.AdopenDbException;

/**
 * @author leon
 * @date 2021-12-13 16:29
 */
public interface BackService {
    Object backToLeon(String appid, String idfa, String ip) throws AdopenDbException;

    Object backToMe(String appid, String idfa, String ip) throws AdopenDbException;
}
