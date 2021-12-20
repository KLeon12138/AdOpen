package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.common.vo.page.PageBase;
import lombok.*;

import java.util.List;

/**
 * 产品绑定列表-page
 *
 * @author leon
 * @date 2021-12-21 00:28
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppBindListVoPage extends PageBase {
    private List<AppBindListVo> appBindContent;

    @Builder(toBuilder = true)
    public AppBindListVoPage(Integer totalPages, Long totalElements, List<AppBindListVo> appBindContent) {
        super(totalPages, totalElements);
        this.appBindContent = appBindContent;
    }
}
