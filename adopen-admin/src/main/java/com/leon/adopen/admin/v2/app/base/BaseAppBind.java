package com.leon.adopen.admin.v2.app.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author leon
 * @date 2021-12-20 18:36
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseAppBind extends BaseApp {
    private Integer cpId;
    private String cpName;
    private String channelCode;
    private BigDecimal channelPrice;
    private String channelOnlineUrl;
    private Boolean isOnStatus;

    public BaseAppBind(Integer appId, String appCode, String appName, Byte platform, Byte type, Integer spId, String spName, BigDecimal price, Integer limitDay, Byte urlType, String previewUrl, String onlineUrl, Byte backFormat, Byte book, String demand, String remark, Integer cpId, String cpName, String channelCode, BigDecimal channelPrice, String channelOnlineUrl, Boolean isOnStatus) {
        super(appId, appCode, appName, platform, type, spId, spName, price, limitDay, urlType, previewUrl, onlineUrl, backFormat, book, demand, remark);
        this.cpId = cpId;
        this.cpName = cpName;
        this.channelCode = channelCode;
        this.channelPrice = channelPrice;
        this.channelOnlineUrl = channelOnlineUrl;
        this.isOnStatus = isOnStatus;
    }
}
