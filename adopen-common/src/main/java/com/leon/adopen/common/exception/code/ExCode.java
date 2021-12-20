package com.leon.adopen.common.exception.code;

import lombok.Getter;

/**
 * @author leon
 * @date 2021-11-29 17:12
 */
@Getter
public enum ExCode {
    /**
     * 自定义异常编码
     */
    lackArgument(400, "缺省参数"),
    badArgument(401, "参数不对"),
    badArgumentValue(402, "参数值不对"),
    updatedDateExpired(403, "更新数据已经失效"),
    updatedDataFailed(404, "更新数据失败"),
    addDataFailed(405, "新增数据失败"),
    delDataFailed(406, "删除数据失败"),
    queryDataFailed(407, "查询数据失败"),
    badReturn(408, "返回码有误"),
    repeatData(409, " 数据重复"),
    serious(502, "系统内部错误"),
    fail(-1, "失败");


    private final int errno;
    private final String errmsg;

    ExCode(int errno, String errmsg) {
        this.errmsg = errmsg;
        this.errno = errno;
    }
}
