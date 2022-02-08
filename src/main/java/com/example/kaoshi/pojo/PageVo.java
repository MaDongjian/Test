package com.example.kaoshi.pojo;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-03-27 9:49
 * @desc
 **/
public class PageVo<T> {
    private Integer limit;//每页显示条数
    private Integer offset;//每页显示数据的开始行号
    private String sort;//要排序的字段
    private Integer total;//总页数
    private String order;//排序规则
    private List<T> rows;//返回数据的集合


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "limit=" + limit +
                ", offset=" + offset +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}
