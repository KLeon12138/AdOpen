package com.leon.adopen.admin.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author leon
 * @date 2021-12-22 11:13
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoBase {
    private String dockerName;
    private String dockerPhone;
    private String dockerEmail;
    private String dockerQq;
    private String dockerWx;
    private String dockerAddr;
}
