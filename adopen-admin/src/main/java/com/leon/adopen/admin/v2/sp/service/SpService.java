package com.leon.adopen.admin.v2.sp.service;

import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.sp.vo.SpListVoPage;
import com.leon.adopen.admin.v2.sp.vo.SpPullDownVo;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author leon
 * @date 2021-12-15 14:34
 */
public interface SpService {
    /**
     * 查询 sp 列表
     *
     * @param requestBase 请求入参基类
     * @param page        分页信息
     * @return {@link  SpListVoPage} 渠道信息
     */
    SpListVoPage listSp(RequestBase requestBase, JsonPage<T> page);

    /**
     * 保存 sp 信息
     *
     * @param requestBase 请求入参基类
     * @throws AdopenException 请求入参空异常或数据重复异常
     */
    void saveSp(RequestBase requestBase) throws AdopenException;

    /**
     * 下拉 SP 信息
     *
     * @return {@link  List<SpPullDownVo>} 下拉SP-vo-list
     */
    List<SpPullDownVo> pullDownSp();
}
