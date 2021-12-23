package com.leon.adopen.admin.v2.cp.service.impl;

import com.leon.adopen.admin.common.request.RequestBase;
import com.leon.adopen.admin.v2.cp.service.CpService;
import com.leon.adopen.admin.v2.cp.vo.CpListVo;
import com.leon.adopen.admin.v2.cp.vo.CpListVoPage;
import com.leon.adopen.admin.v2.cp.vo.CpPullDownVo;
import com.leon.adopen.common.exception.code.ExCode;
import com.leon.adopen.common.exception.example.AdopenException;
import com.leon.adopen.common.jpa.JpaUtil;
import com.leon.adopen.common.utils.StringUtils;
import com.leon.adopen.common.vo.page.JsonPage;
import com.leon.adopen.domain.dao.CpDao;
import com.leon.adopen.domain.entity.Cp;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * cp-impl
 *
 * @author leon
 * @date 2021-12-15 14:34
 */
@Service
public class CpServiceImpl implements CpService {
    @Resource
    private JpaUtil jpaUtil;
    @Resource
    private CpDao cpDao;

    /**
     * cp 列表
     *
     * @param requestBase 请求入参基类
     * @param page        分页信息
     * @return {@link  CpListVoPage} 渠道数据
     */
    @Override
    public CpListVoPage listCp(RequestBase requestBase, JsonPage<T> page) {
        HashMap<String, Object> params = new HashMap<>(16);
        String hql = "select new com.leon.adopen.admin.v2.cp.vo.CpListVo" +
                "(cp.dockerName, cp.dockerPhone, cp.dockerEmail, cp.dockerQq, cp.dockerWx, cp.dockerAddr, cp.id, cp.name, cp.businessMain) " +
                "from Cp cp where 1 = 1 ";
        if (!StringUtils.isEmpty(requestBase.getCpName())) {
            hql += " and cp.name like :cpName";
            params.put("cpName", "%" + requestBase.getCpName() + "%");
        }
        if (!StringUtils.isEmpty(requestBase.getDockerName())) {
            hql += " and cp.dockerName like :dockerName";
            params.put("dockerName", "%" + requestBase.getDockerName() + "%");
        }
        Page<CpListVo> cpPage = jpaUtil.page(hql, params, page.getPageableUnsorted(), CpListVo.class);
        return CpListVoPage.builder()
                .cpContent(cpPage.getContent())
                .totalElements(cpPage.getTotalElements())
                .totalPages(cpPage.getTotalPages()).build();
    }

    /**
     * cp 信息添加
     *
     * @param requestBase 请求入参基类
     * @throws AdopenException 入参空异常
     */
    @Override
    public void saveCp(RequestBase requestBase) throws AdopenException {
        this.verifyRequest(requestBase);
        cpDao.save(this.cpBuilder(requestBase));
    }

    /**
     * 渠道下拉信息
     *
     * @return {@link  List<CpPullDownVo>} 下拉渠道-vo-list
     */
    @Override
    public List<CpPullDownVo> pullDownCp() {
        String hql = "select new com.leon.adopen.admin.v2.cp.vo.CpPullDownVo(cp.id, cp.name) from Cp cp";
        return jpaUtil.list(hql, new HashMap<>(16), CpPullDownVo.class);
    }

    /**
     * 校验入参及渠道重复性
     *
     * @param requestBase 请求入参
     * @throws AdopenException 入参空异常或数据重复
     */
    private void verifyRequest(RequestBase requestBase) throws AdopenException {
        if (StringUtils.isEmpty(requestBase.getCpName())) {
            throw new AdopenException(ExCode.lackArgument, "缺省渠道名称");
        }
        if (cpDao.existsByName(requestBase.getCpName())) {
            throw new AdopenException(ExCode.repeatData, "该渠道已存在");
        }
        if (StringUtils.isEmpty(requestBase.getDockerName())) {
            throw new AdopenException(ExCode.lackArgument, "缺省对接人姓名");
        }
        if (StringUtils.isEmpty(requestBase.getDockerPhone())) {
            throw new AdopenException(ExCode.lackArgument, "缺省对接人联系方式");
        }
    }

    /**
     * 渠道信息构造器
     *
     * @param requestBase 请求入参
     * @return {@link  Cp} 渠道信息
     */
    private Cp cpBuilder(RequestBase requestBase) {
        return Cp.builder()
                .name(requestBase.getCpName())
                .dockerName(requestBase.getDockerName())
                .dockerPhone(requestBase.getDockerPhone())
                .dockerEmail(requestBase.getDockerEmail())
                .dockerQq(requestBase.getDockerQq())
                .dockerWx(requestBase.getDockerWx())
                .dockerAddr(requestBase.getDockerAddr())
                .businessMain(requestBase.getBusinessMain()).build();
    }
}
