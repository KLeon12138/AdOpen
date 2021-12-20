package com.leon.adopen.common.vo.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;

/**
 * @author leon
 * @date 2021-12-15 16:50
 */
public class JsonPage<N> {
    private Integer page = 0;
    private Integer size = 15;
    private Map<String, String> likes;
    private Map<String, N[]> ins;

    public JsonPage() {
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Map<String, String> getLikes() {
        return this.likes;
    }

    public void setLikes(Map<String, String> likes) {
        this.likes = likes;
    }

    public Map<String, N[]> getIns() {
        return this.ins;
    }

    public void setIns(Map<String, N[]> ins) {
        this.ins = ins;
    }

    public Pageable getPageable() {
        Sort sort = Sort.by(Sort.Direction.DESC, new String[]{"id"});
        return PageRequest.of(this.page, this.size, sort);
    }

    public Pageable getPageableUnsorted() {
        return PageRequest.of(this.page, this.size);
    }

    public Pageable getPageableSorted(Sort sort) {
        return PageRequest.of(this.page, this.size, sort);
    }

    public Pageable getPageable(String oredrStr) {
        Sort sort = Sort.by(Sort.Direction.DESC, new String[]{oredrStr});
        return PageRequest.of(this.page, this.size, sort);
    }
}
