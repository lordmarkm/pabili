package com.pabili.commons.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class PageInfo<T> {

    private long total;
    private List<T> data;

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public static <T> PageInfo<T> blank() {
        PageInfo<T> blank = new PageInfo<>();
        blank.setData(new ArrayList<T>());
        blank.setTotal(0);
        return blank;
    }
    public static <T> PageInfo<T> toPageInfo(Page<?> page, List<T> content) {
        PageInfo<T> pageInfo = new PageInfo<T>();
        pageInfo.setData(content);
        pageInfo.setTotal(page.getNumberOfElements());
        return pageInfo;
    }
}