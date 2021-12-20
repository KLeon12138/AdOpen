package com.leon.adopen.admin.v2.cp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leon
 * @date 2021-12-16 11:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CpListVo {
    private Integer cpId;
    private String cpName;
    private String dockerName;
    private String dockerPhone;
    private String dockerEmail;
    private String dockerQq;
    private String dockerWx;
    private String dockerAddr;
    private String businessMain;
}
