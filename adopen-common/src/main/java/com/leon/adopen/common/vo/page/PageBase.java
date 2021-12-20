package com.leon.adopen.common.vo.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 分页基础数据
 *
 * @author leon
 * @date 2021-12-15 17:19
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageBase {
    /**
     * 总页数
     */
    public Integer totalPages;
    /**
     * 总数据量
     */
    public Long totalElements;
}
