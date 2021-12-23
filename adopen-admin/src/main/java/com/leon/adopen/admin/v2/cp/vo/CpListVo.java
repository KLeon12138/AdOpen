package com.leon.adopen.admin.v2.cp.vo;

import com.leon.adopen.admin.common.vo.VoBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author leon
 * @date 2021-12-16 11:15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CpListVo extends VoBase {
    private Integer cpId;
    private String cpName;
    private String businessMain;

    public CpListVo(String dockerName, String dockerPhone, String dockerEmail, String dockerQq, String dockerWx, String dockerAddr, Integer cpId, String cpName, String businessMain) {
        super(dockerName, dockerPhone, dockerEmail, dockerQq, dockerWx, dockerAddr);
        this.cpId = cpId;
        this.cpName = cpName;
        this.businessMain = businessMain;
    }

    public CpListVo(Integer cpId, String cpName) {
        this.cpId = cpId;
        this.cpName = cpName;
    }
}
