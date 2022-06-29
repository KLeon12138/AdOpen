package com.leon.adopen.dock.v2.app.rest;

import com.leon.adopen.common.constants.dock.ClickConstants;
import com.leon.adopen.common.constants.route.RouteConstants;
import com.leon.adopen.dock.v2.app.servicemark.ClickFhService;
import com.leon.adopen.dock.v2.app.servicemark.ClickTtbyService;
import com.leon.adopen.dock.v2.app.servicemark.ClickXzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 上报点击
 *
 * @author leon
 * @date 2021-12-24 11:30
 */
@RestController
@RequestMapping(RouteConstants.DOCK_PORT_CLICK)
@Validated
@Slf4j
public class ClickRest {
    @Resource
    private ClickTtbyService ttbyService;
    @Resource
    private ClickXzService xzService;
    @Resource
    private ClickFhService fhService;

    /**
     * 天天捕鱼
     *
     * @param appid   产品 id
     * @param idfa    idfa 标识
     * @param ip      设备 ip
     * @param channel 渠道号
     * @return {@link  String} 通用返回类
     * @throws Exception 通用异常
     */
    @GetMapping("/ttby")
    public String clickTtby(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip, @RequestParam String channel, @RequestParam String callback) throws Exception {
        ttbyService.click(appid, idfa, ip, channel, callback);
        return ClickConstants.DEFAULT_RESULT;
    }

    /**
     * 仙战
     *
     * @param appid   产品 id
     * @param idfa    idfa 标识
     * @param ip      设备 ip
     * @param channel 渠道号
     * @return {@link  String} 通用返回类
     * @throws Exception 通用异常
     */
    @GetMapping("/xz")
    public String clickXz(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip, @RequestParam String channel, @RequestParam String callback) throws Exception {
        xzService.click(appid, idfa, ip, channel, callback);
        return ClickConstants.DEFAULT_RESULT;
    }

    /**
     * 凤凰传奇
     *
     * @param appid   产品 id
     * @param idfa    idfa 标识
     * @param ip      设备 ip
     * @param channel 渠道号
     * @return {@link  String} 通用返回类
     * @throws Exception 通用异常
     */
    @GetMapping("/fh")
    public String clickFh(@RequestParam String appid, @RequestParam String idfa, @RequestParam String ip, @RequestParam String channel, @RequestParam String callback) throws Exception {
        fhService.click(appid, idfa, ip, channel, callback);
        return ClickConstants.DEFAULT_RESULT;
    }
}
