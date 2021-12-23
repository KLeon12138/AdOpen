package com.leon.adopen.admin.v2.sp.vo;

import com.leon.adopen.admin.common.vo.VoBase;
import lombok.*;

/**
 * SP列表-vo
 *
 * @author leon
 * @date 2021-12-16 11:22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpListVo extends VoBase {
    private Integer spId;
    private String spName;
    private String needMain;

    public SpListVo(String dockerName, String dockerPhone, String dockerEmail, String dockerQq, String dockerWx, String dockerAddr, Integer spId, String spName, String needMain) {
        super(dockerName, dockerPhone, dockerEmail, dockerQq, dockerWx, dockerAddr);
        this.spId = spId;
        this.spName = spName;
        this.needMain = needMain;
    }

    public SpListVo(Integer spId, String spName) {
        this.spId = spId;
        this.spName = spName;
    }
}
