package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.common.vo.page.PageBase;
import lombok.*;

import java.util.List;

/**
 * @author leon
 * @date 2021-12-26 22:21
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppClickListVoPage extends PageBase {
    List<AppClickListVo> clickContent;

    @Builder(toBuilder = true)
    public AppClickListVoPage(Integer totalPages, Long totalElements, List<AppClickListVo> clickContent) {
        super(totalPages, totalElements);
        this.clickContent = clickContent;
    }
}
