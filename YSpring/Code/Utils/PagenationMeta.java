package com.module.admin_module.Utils;

import org.springframework.data.domain.Page;

public class PagenationMeta {
    
    //total no of records---100
    //per page  size --10
    //total no of page---10
    // page number--1...10 (1-->1-10, 2-->11-20)
    // isfirstpage
    // islastpage

    private Long totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer pageNumber;
    private boolean isLast;
    private boolean isFirst;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }
    
    public static <T> PagenationMeta createPagenation(Page<T> page){
        
        PagenationMeta pg=new PagenationMeta();
        pg.setTotalCount(page.getTotalElements());    
        pg.setPageSize(page.getSize());
        pg.setTotalPage(page.getTotalPages());
        pg.setPageNumber(page.getNumber());
        pg.setFirst(page.isFirst());
        pg.setLast(page.isLast());
        return pg;
    }

    // private Long totalCount;
    // private Integer pageSize;
    // private Integer totalPage;
    // private Integer pageNumber;
    // private boolean isLast;
    // private boolean isFirst;

}
