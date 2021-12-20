package com.leon.adopen.domain.exception.enums;

import lombok.Getter;

/**
 * 操作DAO错误码，可能配置其他错误码
 *
 * @author leon
 * @date 2021/11/25
 */
@Getter
public enum AdopenDbCode {
    /**
     * 更新数据失效
     */
    updatedDateExpired(101, "更新数据已经失效"),
    /**
     * 更新数据失败
     */
    updatedDataFailed(102, "更新数据失败"),
    /**
     * 新增数据失败
     */
    insertDataFailed(103, "新增数据失败"),
    /**
     * 查询数据失败
     */
    selectDataFailed(104, "查询数据失败"),
    /**
     * 存在该条数据
     */
    exsitDataFailed(105, "存在该条数据"),
    /**
     * 数据为空
     */
    nullDataFailed(106, "数据为空"),
    /**
     * 缺省参数
     */
    lackData(107, "缺省参数");

    private final int errno;
    private final String errmsg;

    AdopenDbCode(int errno, String errmsg) {
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public int getErrno() {
        return errno;
    }

    public String getErrmsg() {
        return errmsg;
    }
}
