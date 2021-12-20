package com.leon.adopen.admin.v2.sp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leon
 * @date 2021-12-16 11:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpListVo {
    private Integer spId;
    private String spName;
    private String dockerName;
    private String dockerPhone;
    private String dockerEmail;
    private String dockerQq;
    private String dockerWx;
    private String dockerAddr;
    private String needMain;
}
