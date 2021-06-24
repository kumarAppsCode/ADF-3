package com.spring.contractvb.DataResponse;

import java.util.List;

import com.spring.contractvb.Entity.Customer_EO;


public class CustomerAPI{



    private List<Customer_EO> items;
    private long count;
    private boolean hasMore;
    private long limit;
    private boolean isLast;
    private boolean isFirst;
    private long offset;
    private Integer page;


    public List<Customer_EO> getItems() {
        return items;
    }

    public void setItems(List<Customer_EO> items) {
        this.items = items;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
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

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

 


}
