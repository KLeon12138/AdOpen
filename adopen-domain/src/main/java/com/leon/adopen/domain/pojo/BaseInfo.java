package com.leon.adopen.domain.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求数据存储对象
 *
 * @author leon
 * @date 2019/07/02
 */
@Setter
@Getter
@NoArgsConstructor
public class BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String appId;
    private String channel;
    private String idfa;
    private String ip;
    private String sign;
    private String callback;
    private String status;
    private String remark;
    private String source;

    public BaseInfo(String appId, String channel, String idfa, String ip, String callback) {
        this.appId = appId;
        this.channel = channel;
        this.idfa = idfa;
        this.ip = ip;
        this.callback = callback;
    }

    public BaseInfo(String appId, String idfa, String ip) {
        this.appId = appId;
        this.idfa = idfa;
        this.ip = ip;
    }
}
