package com.leon.adopen.admin.v2.app.service.impl;

import com.leon.adopen.admin.v2.app.request.AppBindListRequest;
import com.leon.adopen.admin.v2.app.request.AppBindAllotRequest;
import com.leon.adopen.admin.v2.app.service.AppBindService;
import com.leon.adopen.admin.v2.app.vo.AppBindListVo;
import com.leon.adopen.admin.v2.app.vo.AppBindListVoPage;
import com.leon.adopen.common.constants.app.AppBindStatusConstants;
import com.leon.adopen.common.constants.app.AppCodeConstants;
import com.leon.adopen.common.constants.app.AppComConstants;
import com.leon.adopen.common.constants.date.InitDateConstants;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.jpa.JpaUtil;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.dao.*;
import com.leon.adopen.domain.entity.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author leon
 * @date 2021-12-20 16:12
 */
@Service
public class AppBindServiceImpl implements AppBindService {
    @Resource
    private JpaUtil jpaUtil;
    @Resource
    private AppBindDao appBindDao;
    @Resource
    private AppDao appDao;
    @Resource
    private SpDao spDao;
    @Resource
    private CpDao cpDao;
    @Resource
    private AppClickDao appClickDao;

    private static final String KEY_APP_BIND = "AppBind";
    private static final String KEY_APP_CLICK = "AppCLICK";

    /**
     * 产品绑定列表
     *
     * @param request 产品绑定列表-request
     * @param page    分页信息
     * @return {@link  AppBindListVoPage}  产品绑定列表-page
     */
    @Override
    public AppBindListVoPage listAppBind(AppBindListRequest request, JsonPage<T> page) {
        HashMap<String, Object> params = new HashMap<>(16);
        String hql = "select new com.leon.adopen.admin.v2.app.vo.AppBindListVo" +
                "(ab.appId, ab.appCode, ab.appName, app.platform, app.type, ab.spId, ab.spName, app.price, app.limitDay, app.urlType, " +
                "app.previewUrl, app.onlineUrl, app.backFormat, app.book, app.demand, app.remark, ab.cpId, ab.cpName, ab.channelCode, ab.price, " +
                "ab.onlineUrl, ab.isOnStatus) " +
                "from AppBind ab " +
                "left join App app on ab.appId = app.id " +
                "left join Sp sp on ab.spId = sp.id " +
                "where ab.isdel <> 1";
        if (!StringUtils.isEmpty(request.getAppName())) {
            hql += " and ab.appName like :appName";
            params.put("appName", "%" + request.getAppName() + "%");
        }
        if (!StringUtils.isEmpty(request.getAppCode())) {
            hql += " and ab.appCode like :appCode";
            params.put("appCode", "%" + request.getAppCode() + "%");
        }
        if (!StringUtils.isEmpty(request.getSpName())) {
            hql += " and ab.spName like :spName";
            params.put("spName", "%" + request.getSpName() + "%");
        }
        if (!StringUtils.isEmpty(request.getCpName())) {
            hql += " and ab.cpName like :cpName";
            params.put("cpName", "%" + request.getCpName() + "%");
        }
        if (!StringUtils.isEmpty(request.getChannelCode())) {
            hql += " and ab.channelCode = :channelCode";
            params.put("channelCode", request.getChannelCode());
        }
        Page<AppBindListVo> appBindListVoPage = jpaUtil.page(hql, params, page.getPageableUnsorted(), AppBindListVo.class);
        return AppBindListVoPage.builder()
                .appBindContent(appBindListVoPage.getContent())
                .totalElements(appBindListVoPage.getTotalElements())
                .totalPages(appBindListVoPage.getTotalPages())
                .build();
    }

    /**
     * 绑定产品
     *
     * @param request 产品绑定分配-request
     * @throws AdopenException 入参空、数据重复、数据无效等异常
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void allot(AppBindAllotRequest request) throws AdopenException {
        this.verifyAppBindRequest(request);
        HashMap<String, Object> allBuilder = this.appBindAndClickBuilder(request);
        appBindDao.save((AppBind) allBuilder.get(KEY_APP_BIND));
        appClickDao.save((AppClick) allBuilder.get(KEY_APP_CLICK));
    }

    /**
     * 校验入参
     *
     * @param request 产品绑定分配-request
     * @throws AdopenException 入参空、数据重复等异常
     */
    private void verifyAppBindRequest(AppBindAllotRequest request) throws AdopenException {
        if (StringUtils.isEmpty(request.getAppId())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品id");
        }
        if (StringUtils.isEmpty(request.getCpId())) {
            throw new AdopenException(ExCode.lackArgument, "缺省渠道id");
        }
        if (StringUtils.isEmpty(request.getChannelCode())) {
            throw new AdopenException(ExCode.lackArgument, "缺省渠道码");
        }
        if (appBindDao.existsByChannelCodeAndIsdel(request.getChannelCode(), AppComConstants.APP_BIND_NOT_DEL)) {
            throw new AdopenException(ExCode.repeatData, "该渠道码已被分配,请重新配置;渠道码:" + request.getChannelCode());
        }
        if (StringUtils.isEmpty(request.getChannelPrice())) {
            throw new AdopenException(ExCode.lackArgument, "缺省下发单价");
        }
        if (StringUtils.isEmpty(request.getChannelOnlineUrl())) {
            throw new AdopenException(ExCode.lackArgument, "缺省渠道上线链接");
        }
    }

    /**
     * 绑定产品及当日点击记录构造器
     *
     * @param request 产品绑定分配-request
     * @return {@link  AppBind}   绑定产品
     * @throws AdopenException 数据无效等异常
     */
    private HashMap<String, Object> appBindAndClickBuilder(AppBindAllotRequest request) throws AdopenException {
        App app = appDao.findById(request.getAppId()).orElse(null);
        if (StringUtils.isEmpty(app)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该产品;产品id:" + request.getAppId());
        }
        Sp sp = spDao.findById(app.getSpId()).orElse(null);
        if (StringUtils.isEmpty(sp)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该sp信息;sp id:" + request.getSpId());
        }
        Cp cp = cpDao.findById(request.getCpId()).orElse(null);
        if (StringUtils.isEmpty(cp)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该cp信息;cp id:" + request.getCpId());
        }
        if (appClickDao.existsByChannelCodeAndClickDate(request.getChannelCode(), InitDateConstants.DATE_SHORT_TODAY)) {
            throw new AdopenException(ExCode.repeatData, "今日已有该产品点击记录");
        }
        //构造产品分配记录
        AppBind appBind = AppBind.builder()
                .appId(app.getId())
                .appCode(app.getAppCode())
                .appName(app.getAppName())
                .spId(sp.getId())
                .spName(sp.getName())
                .cpId(cp.getId())
                .cpName(cp.getName())
                .channelCode(request.getChannelCode())
                .price(request.getChannelPrice())
                .onlineUrl(request.getChannelOnlineUrl())
                .build();
        //构造当日点击记录
        AppClick appClick = AppClick.builder()
                .appId(app.getId())
                .appCode(app.getAppCode())
                .appName(app.getAppName())
                .spId(sp.getId())
                .spName(sp.getName())
                .cpId(cp.getId())
                .cpName(cp.getName())
                .channelCode(request.getChannelCode())
                .limitDay(app.getLimitDay())
                .clickDate(InitDateConstants.DATE_TODAY).build();
        HashMap<String, Object> result = new HashMap<>(2);
        result.put(KEY_APP_BIND, appBind);
        result.put(KEY_APP_CLICK, appClick);
        return result;
    }

    /**
     * 更新产品绑定上线状态
     *
     * @param appCode 产品编码
     * @param isOn    产品
     * @return {@link  Boolean}    上线状态
     */
    @Override
    public Boolean updateIsOn(String appCode, Boolean isOn) {
        if (appCode.equals(AppCodeConstants.YDWX_A1)) {
            AppBindStatusConstants.BIND_YDWX_A1 = isOn;
            return AppBindStatusConstants.BIND_YDWX_A1;
        }
        return AppBindStatusConstants.DEFAULT_APP_BIND_STATUS;
    }
}
