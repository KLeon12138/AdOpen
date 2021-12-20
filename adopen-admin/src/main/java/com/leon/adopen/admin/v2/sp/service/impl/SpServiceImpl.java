package com.leon.adopen.admin.v2.sp.service.impl;

import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.sp.service.SpService;
import com.leon.adopen.admin.v2.sp.vo.SpListVo;
import com.leon.adopen.admin.v2.sp.vo.SpListVoPage;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.jpa.JpaUtil;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.dao.SpDao;
import com.leon.adopen.domain.entity.Sp;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author leon
 * @date 2021-12-15 14:34
 */
@Service
public class SpServiceImpl implements SpService {
    @Resource
    private JpaUtil jpaUtil;
    @Resource
    private SpDao spDao;

    /**
     * Sp 列表
     *
     * @param requestBase 请求入参基类
     * @param page        分页信息
     * @return {@link  SpListVoPage} 渠道数据
     */
    @Override
    public SpListVoPage listSp(RequestBase requestBase, JsonPage<T> page) {
        HashMap<String, Object> params = new HashMap<>(16);
        String hql = "select new com.leon.adopen.admin.v2.sp.vo.SpListVo" +
                "(sp.id, sp.name, sp.dockerName, sp.dockerPhone, sp.dockerEmail, sp.dockerQq, sp.dockerWx, sp.dockerAddr, sp.needMain) " +
                "from Sp sp where 1 = 1";
        if (!StringUtils.isEmpty(requestBase.getSpName())) {
            hql += " and sp.name like :spName";
            params.put("spName", "%" + requestBase.getSpName() + "%");
        }
        if (!StringUtils.isEmpty(requestBase.getDockerName())) {
            hql += " and sp.dockerName like :dockerName";
            params.put("dockerName", "%" + requestBase.getDockerName() + "%");
        }
        Page<SpListVo> cpPage = jpaUtil.page(hql, params, page.getPageableUnsorted(), SpListVo.class);
        return SpListVoPage.builder()
                .spContent(cpPage.getContent())
                .totalElements(cpPage.getTotalElements())
                .totalPages(cpPage.getTotalPages()).build();
    }

    /**
     * Sp 信息添加
     *
     * @param requestBase 请求入参基类
     * @throws AdopenException 入参空异常
     */
    @Override
    public void saveSp(RequestBase requestBase) throws AdopenException {
        this.verifyRequest(requestBase);
        spDao.save(this.spBuilder(requestBase));
    }

    /**
     * 校验入参及上游重复性
     *
     * @param requestBase 请求入参
     * @throws AdopenException 入参空异常或数据重复
     */
    private void verifyRequest(RequestBase requestBase) throws AdopenException {
        if (StringUtils.isEmpty(requestBase.getSpName())) {
            throw new AdopenException(ExCode.lackArgument, "缺省上游名称");
        }
        if (spDao.existsByName(requestBase.getSpName())) {
            throw new AdopenException(ExCode.repeatData, "该上游已存在");
        }
        if (StringUtils.isEmpty(requestBase.getDockerName())) {
            throw new AdopenException(ExCode.lackArgument, "缺省对接人姓名");
        }
        if (StringUtils.isEmpty(requestBase.getDockerPhone())) {
            throw new AdopenException(ExCode.lackArgument, "缺省对接人联系方式");
        }
    }

    /**
     * 上游信息构造器
     *
     * @param requestBase 请求入参
     * @return {@link  Sp} 渠道信息
     */
    private Sp spBuilder(RequestBase requestBase) {
        return Sp.builder()
                .name(requestBase.getCpName())
                .dockerName(requestBase.getDockerName())
                .dockerPhone(requestBase.getDockerPhone())
                .dockerEmail(requestBase.getDockerEmail())
                .dockerQq(requestBase.getDockerQq())
                .dockerWx(requestBase.getDockerWx())
                .dockerAddr(requestBase.getDockerAddr())
                .needMain(requestBase.getBusinessMain()).build();
    }
}
