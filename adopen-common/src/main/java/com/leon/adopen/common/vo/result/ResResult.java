package com.leon.adopen.common.vo.result;

/**
 * @author leon
 * @date 2021-12-15 14:57
 */
public interface ResResult {
    void setCode(int var1);

    int getCode();

    Object getData();

    Object getData(String var1);

    Object removeData(String var1);
}
