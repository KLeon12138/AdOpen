package com.leon.adopen.admin.v2.cp.vo;

import com.leon.adopen.common.vo.page.PageBase;
import lombok.*;

import java.util.List;

/**
 * @author leon
 * @date 2021-12-15 17:14
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CpListVoPage extends PageBase {
    List<CpListVo> cpContent;

    @Builder(toBuilder = true)
    public CpListVoPage(Integer totalPages, Long totalElements, List<CpListVo> cpContent) {
        super(totalPages, totalElements);
        this.cpContent = cpContent;
    }
}
