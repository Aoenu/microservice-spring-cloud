package com.example.page;


import java.util.List;

/**
 *
 * @author ykzhen2015
 */
public class PageParams {

    private Integer page;//第几页
    private Integer pageSize;//每页限制条数
    private Boolean useFlag;//是否启动插件，如果不启动，则不作分页
    private Boolean checkFlag;//是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
    private Boolean cleanOrderBy;//是否清除最后order by 后面的语句
    private Integer total; //总条数，插件会回填这个值
    private Integer totalPage; //总页数，插件会回填这个值.

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public Boolean getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Boolean checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Boolean getCleanOrderBy() {
        return cleanOrderBy;
    }

    public void setCleanOrderBy(Boolean cleanOrderBy) {
        this.cleanOrderBy = cleanOrderBy;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}