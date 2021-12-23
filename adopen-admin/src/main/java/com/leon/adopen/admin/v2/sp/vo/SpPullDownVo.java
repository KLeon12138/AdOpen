package com.leon.adopen.admin.v2.sp.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 下拉SP-vo
 *
 * @author leon
 * @date 2021-12-22 14:04
 */
@Getter
@Setter
public class SpPullDownVo extends SpListVo {
    public SpPullDownVo(Integer spId, String spName) {
        super(spId, spName);
    }
}
