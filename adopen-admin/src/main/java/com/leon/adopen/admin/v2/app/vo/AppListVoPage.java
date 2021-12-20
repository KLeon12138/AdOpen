package com.leon.adopen.admin.v2.app.vo;

import com.leon.adopen.common.vo.page.PageBase;
import lombok.*;

import java.util.List;

/**
 * 产品分页数据
 *
 * @author leon
 * @date 2021-12-16 11:50
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppListVoPage extends PageBase {
    List<AppListVo> appContent;

    @Builder(toBuilder = true)
    public AppListVoPage(Integer totalPages, Long totalElements, List<AppListVo> appContent) {
        super(totalPages, totalElements);
        this.appContent = appContent;
    }
}
