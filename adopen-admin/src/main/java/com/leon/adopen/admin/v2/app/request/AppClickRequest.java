package com.leon.adopen.admin.v2.app.request;

import com.leon.adopen.admin.v2.app.base.BaseApp;
import lombok.Getter;
import lombok.Setter;

/**
 * 产品点击-request
 *
 * @author leon
 * @date 2021-12-26 22:26
 */
@Getter
@Setter
public class AppClickRequest extends BaseApp {
    private String channelCode;
    private String clickDate;
}
