package org.zhezhela.zonky.dto.filter;

import java.util.List;

public class ZonkyRequestParams {

    private ZonkyPagination pagination;
    private List<ZonkySortItem> sort;
    private List<ZonkyFilterItem> filter;

    public ZonkyPagination getPagination() {
        return pagination;
    }

    public void setPagination(ZonkyPagination pagination) {
        this.pagination = pagination;
    }

    public List<ZonkySortItem> getSort() {
        return sort;
    }

    public void setSort(List<ZonkySortItem> sort) {
        this.sort = sort;
    }

    public List<ZonkyFilterItem> getFilter() {
        return filter;
    }

    public void setFilter(List<ZonkyFilterItem> filter) {
        this.filter = filter;
    }
}
