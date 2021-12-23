package com.leon.adopen.dock.v2.task.service;

import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.domain.entity.AppClick;
import com.leon.adopen.domain.exception.ex.AdopenDbException;

import java.util.List;

/**
 * 产品点击定时任务
 *
 * @author leon
 * @date 2021-12-22 16:21
 */
public interface AppClickTaskService {
    /**
     * 刷新产品点击
     *
     * @param shortNowNoChar 短字符日期
     * @return {@link  Object } 刷新记录
     * @throws AdopenDbException 空数据异常
     */
    Object refreshClick(String shortNowNoChar) throws AdopenDbException;

    /**
     * 初始化产品点击
     *
     * @param date 点击日期
     * @return {@link  List<AppClick> } 产品点击记录
     * @throws AdopenException 空数据异常
     */
    List<AppClick> initClick(String date) throws AdopenException;
}
