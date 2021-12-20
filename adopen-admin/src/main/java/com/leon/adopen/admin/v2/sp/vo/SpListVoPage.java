package com.leon.adopen.admin.v2.sp.vo;

import com.leon.adopen.common.vo.page.PageBase;
import lombok.*;

import java.util.List;

/**
 * @author leon
 * @date 2021-12-15 18:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SpListVoPage extends PageBase {
    List<SpListVo> spContent;

    @Builder(toBuilder = true)
    public SpListVoPage(Integer totalPages, Long totalElements, List<SpListVo> spContent) {
        super(totalPages, totalElements);
        this.spContent = spContent;
    }
}
