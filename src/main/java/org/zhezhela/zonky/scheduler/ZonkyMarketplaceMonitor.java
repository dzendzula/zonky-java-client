package org.zhezhela.zonky.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.zhezhela.zonky.dto.ZonkyLoanDto;
import org.zhezhela.zonky.dto.filter.*;
import org.zhezhela.zonky.service.ZonkyApiService;

import java.util.Collections;
import java.util.List;

@Component
public class ZonkyMarketplaceMonitor {

    private Logger log = LoggerFactory.getLogger(ZonkyMarketplaceMonitor.class);

    @Autowired
    private ZonkyApiService zonkyApiService;

    @Scheduled(fixedDelayString = "${zonky.marketplace.monitor.delay:30000}")
    private void monitor() {

        List<ZonkyLoanDto> result = zonkyApiService.getLoans(createRequestParams());
        if (!CollectionUtils.isEmpty(result)) {
            log.info("================== Zonky Marketplace ==========================");
            result.forEach(l -> log.info(l.toString()));
            log.info("===============================================================");
        }
    }

    private ZonkyRequestParams createRequestParams() {
        ZonkyRequestParams params = new ZonkyRequestParams();
        ZonkyPagination pagination = new ZonkyPagination();
        pagination.setTotal(30);
        pagination.setSize(10);
        pagination.setPage(1);
        params.setPagination(pagination);

        ZonkySortItem sortItem = new ZonkySortItem();
        sortItem.setFieldName(ZonkyFieldName.PURPOSE);
        sortItem.setDirection(ZonkySortItem.SortDirection.DESC);
        params.setSort(Collections.singletonList(sortItem));

        ZonkyFilterItem filterItem = new ZonkyFilterItem();
        filterItem.setFieldName(ZonkyFieldName.AMOUNT);
        filterItem.setOperationalSuffix(ZonkyFilterItem.OperationalSuffix.GTE);
        filterItem.setValue("100");
        params.setFilter(Collections.singletonList(filterItem));

        return params;
    }

}
