package com.leon.adopen.admin.v2.cp.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 下拉渠道-vo
 *
 * @author leon
 * @date 2021-12-22 11:12
 */
@Getter
@Setter
public class CpPullDownVo extends CpListVo {
    public CpPullDownVo(Integer cpId, String cpName) {
        super(cpId, cpName);
    }
}
