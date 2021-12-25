package com.leon.adopen.admin.v2.app.service.impl;

import com.leon.adopen.admin.v2.app.request.AppListRequest;
import com.leon.adopen.admin.v2.app.request.AppSaveRequest;
import com.leon.adopen.admin.v2.app.service.AppService;
import com.leon.adopen.admin.v2.app.vo.AppListVo;
import com.leon.adopen.admin.v2.app.vo.AppListVoPage;
import com.leon.adopen.admin.v2.app.vo.AppPullDownVo;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.jpa.JpaUtil;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.dao.AppDao;
import com.leon.adopen.domain.dao.SpDao;
import com.leon.adopen.domain.entity.App;
import com.leon.adopen.domain.entity.Sp;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * app-impl
 *
 * @author leon
 * @date 2021-12-16 14:21
 */
@Service
public class AppServiceImpl implements AppService {
    @Resource
    private JpaUtil jpaUtil;
    @Resource
    private AppDao appDao;
    @Resource
    private SpDao spDao;

    /**
     * 产品列表
     *
     * @param request 产品列表请求数据
     * @param page    分页信息
     * @return {@link  AppListVoPage}  产品分页数据
     */
    @Override
    public AppListVoPage listApp(AppListRequest request, JsonPage<T> page) {
        HashMap<String, Object> params = new HashMap<>(16);
        String hql = "select new com.leon.adopen.admin.v2.app.vo.AppListVo"
                + "(app.id, app.appCode, app.appName, app.platform, app.type, app.spId, app.spName, app.price, app.limitDay, app.urlType, app.previewUrl, " +
                "app.onlineUrl, app.backFormat, app.book, app.demand, app.isRemove, app.remark) "
                + "from App app where 1 = 1 ";
        if (!StringUtils.isEmpty(request.getAppCode())) {
            hql += " and app.appCode like :appCode";
            params.put("appCode", request.getAppCode());
        }
        if (!StringUtils.isEmpty(request.getAppName())) {
            hql += " and app.appName like :appName";
            params.put("appName", request.getAppName());
        }
        if (!StringUtils.isEmpty(request.getSpName())) {
            hql += " and app.spName like :spName";
            params.put("spName", request.getSpName());
        }
        Page<AppListVo> appPage = jpaUtil.page(hql, params, page.getPageableUnsorted(), AppListVo.class);
        return AppListVoPage.builder()
                .appContent(appPage.getContent())
                .totalElements(appPage.getTotalElements())
                .totalPages(appPage.getTotalPages()).build();
    }

    /**
     * 产品新增
     *
     * @param request 产品保存请求数据
     * @throws AdopenException 入参空异常或数据重复异常
     */
    @Override
    public void saveApp(AppSaveRequest request) throws AdopenException {
        this.verifyAppSaveRequest(request);
        appDao.save(this.appBuilder(request));
    }

    /**
     * 产品下拉数据
     *
     * @return {@link  List<AppPullDownVo>}    产品下拉数据
     */
    @Override
    public List<AppPullDownVo> pullDownApp() {
        String hql = "select new com.leon.adopen.admin.v2.app.vo.AppPullDownVo(app.id, app.appName) from App app";
        return jpaUtil.list(hql, new HashMap<>(16), AppPullDownVo.class);
    }

    /**
     * 校验产品新增请求数据
     *
     * @param request 产品新增请求数据
     * @throws AdopenException 入参空异常或数据重复异常
     */
    private void verifyAppSaveRequest(AppSaveRequest request) throws AdopenException {
        if (StringUtils.isEmpty(request.getAppCode())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品编码");
        }
        if (appDao.existsByAppCode(request.getAppCode())) {
            throw new AdopenException(ExCode.repeatData, "该产品编码已存在");
        }
        if (StringUtils.isEmpty(request.getAppName())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品名称");
        }
        if (StringUtils.isEmpty(request.getPlatform())) {
            throw new AdopenException(ExCode.lackArgument, "缺省平台");
        }
        if (StringUtils.isEmpty(request.getType())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品类型");
        }
        if (StringUtils.isEmpty(request.getSpId())) {
            throw new AdopenException(ExCode.lackArgument, "缺省上游id");
        }
        if (!spDao.existsById(request.getSpId())) {
            throw new AdopenException(ExCode.queryDataFailed, "无该SP-ID;spId:" + request.getSpId());
        }
        if (StringUtils.isEmpty(request.getPrice())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品单价");
        }
        if (StringUtils.isEmpty(request.getLimitDay())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品日限");
        }
        if (StringUtils.isEmpty(request.getUrlType())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品链接类型");
        }
        if (StringUtils.isEmpty(request.getPreviewUrl())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品预览链接");
        }
        if (StringUtils.isEmpty(request.getOnlineUrl())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品上线链接");
        }
        if (StringUtils.isEmpty(request.getBackFormat())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品返数格式");
        }
        if (StringUtils.isEmpty(request.getBook())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品帐期");
        }
        if (StringUtils.isEmpty(request.getDemand())) {
            throw new AdopenException(ExCode.lackArgument, "缺省产品要求");
        }
    }

    /**
     * 产品构造器
     *
     * @param request 产品新增请求数据
     * @return {@link  App}    产品信息
     */
    private App appBuilder(AppSaveRequest request) throws AdopenException {
        Sp sp = spDao.findById(request.getSpId()).orElse(null);
        if (StringUtils.isEmpty(sp)) {
            throw new AdopenException(ExCode.queryDataFailed, "无该SP信息;spId:" + request.getSpId());
        }
        return App.builder()
                .appCode(request.getAppCode())
                .appName(request.getAppName())
                .platform(request.getPlatform())
                .type(request.getType())
                .spId(request.getSpId())
                .spName(sp.getName())
                .price(request.getPrice())
                .limitDay(request.getLimitDay())
                .urlType(request.getUrlType())
                .previewUrl(request.getPreviewUrl())
                .onlineUrl(request.getOnlineUrl())
                .backFormat(request.getBackFormat())
                .book(request.getBook())
                .demand(request.getDemand())
                .remark(request.getRemark()).build();
    }
}
