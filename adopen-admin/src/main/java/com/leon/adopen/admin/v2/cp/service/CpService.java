package com.leon.adopen.admin.v2.cp.service;

import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.cp.vo.CpListVoPage;
import com.leon.adopen.admin.v2.cp.vo.CpPullDownVo;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.vo.page.JsonPage;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * cp-service
 *
 * @author leon
 * @date 2021-12-15 14:33
 */
public interface CpService {
    /**
     * 查询 cp 列表
     *
     * @param requestBase 请求入参基类
     * @param page        分页信息
     * @return {@link  CpListVoPage} 渠道信息
     */
    CpListVoPage listCp(RequestBase requestBase, JsonPage<T> page);

    /**
     * 保存 cp 信息
     *
     * @param requestBase 请求入参基类
     * @throws AdopenException 请求入参空异常或数据重复异常
     */
    void saveCp(RequestBase requestBase) throws AdopenException;

    /**
     * 渠道下拉信息
     *
     * @return {@link  List<CpPullDownVo>} 下拉渠道-vo-list
     */
    List<CpPullDownVo> pullDownCp();
}
