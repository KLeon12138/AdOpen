package com.leon.adopen.admin.v2.app.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author leon
 * @date 2021-12-16 14:22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseApp {
    /**
     * 产品 id
     */
    private Integer appId;
    /**
     * 产品编码
     */
    private String appCode;
    /**
     * 产品名称
     */
    private String appName;
    /**
     * 产品平台(1:ios;2:android;3:小程序:4:双端)
     */
    private Byte platform;
    /**
     * 产品类型(1:cpa;2:cps)
     */
    private Byte type;
    /**
     * 上游 id
     */
    private Integer spId;
    /**
     * 上游名称
     */
    private String spName;
    /**
     * 产品单价
     */
    private BigDecimal price;
    /**
     * 产品日限
     */
    private Integer limitDay;
    /**
     * 链接类型(1:对接;2:短链)
     */
    private Byte urlType;
    /**
     * 预览链接
     */
    private String previewUrl;
    /**
     * 上线链接
     */
    private String onlineUrl;
    /**
     * 返数格式(1:后台截图;2:表格截图)
     */
    private Byte backFormat;
    /**
     * 帐期(1:日结;2:周结;3:月结;4:N+1;5:N+2)
     */
    private Byte book;
    /**
     * 考核要求
     */
    private String demand;
    /**
     * 移除状态
     */
    private Boolean isRemove;
    /**
     * 备注
     */
    private String remark;

    public BaseApp(Integer appId, String appCode, String appName, Byte platform, Byte type, Integer spId, String spName, BigDecimal price, Integer limitDay, Byte urlType, String previewUrl, String onlineUrl, Byte backFormat, Byte book, String demand, String remark) {
        this.appId = appId;
        this.appCode = appCode;
        this.appName = appName;
        this.platform = platform;
        this.type = type;
        this.spId = spId;
        this.spName = spName;
        this.price = price;
        this.limitDay = limitDay;
        this.urlType = urlType;
        this.previewUrl = previewUrl;
        this.onlineUrl = onlineUrl;
        this.backFormat = backFormat;
        this.book = book;
        this.demand = demand;
        this.remark = remark;
    }

    public BaseApp(Integer appId, String appName) {
        this.appId = appId;
        this.appName = appName;
    }

    public BaseApp(Integer appId, String appCode, String appName, String spName, Integer limitDay) {
        this.appId = appId;
        this.appCode = appCode;
        this.appName = appName;
        this.spName = spName;
        this.limitDay = limitDay;
    }
}
