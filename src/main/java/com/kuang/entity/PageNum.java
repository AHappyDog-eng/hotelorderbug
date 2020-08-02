package com.kuang.entity;

public class PageNum {
    private Integer pageNum;
    private Integer limitNum;

    @Override
    public String toString() {
        return "PageNum{" +
                "pageNum=" + pageNum +
                ", limitNum=" + limitNum +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public PageNum() {
    }

    public PageNum(Integer pageNum, Integer limitNum) {
        this.pageNum = pageNum;
        this.limitNum = limitNum;
    }
}
