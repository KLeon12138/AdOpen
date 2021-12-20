package com.leon.adopen.admin.common.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求基类
 *
 * @author leon
 * @date 2021-12-15 16:17
 */
@Getter
@Setter
public class RequestBase {
    /**
     * 上游id
     */
    private Integer spId;
    /**
     * 上游名称
     */
    private String spName;
    /**
     * 渠道id
     */
    private Integer cpId;
    /**
     * 渠道名称
     */
    private String cpName;
    /**
     * 对接人姓名
     */
    private String dockerName;
    /**
     * 对接人联系方式
     */
    private String dockerPhone;
    /**
     * 对接人邮箱
     */
    private String dockerEmail;
    /**
     * 对接人 qq 号
     */
    private String dockerQq;
    /**
     * 对接人微信
     */
    private String dockerWx;
    /**
     * 对接人地址
     */
    private String dockerAddr;
    /**
     * 主营业务
     */
    private String businessMain;
    /**
     * 主要需求
     */
    private String needMain;
}
