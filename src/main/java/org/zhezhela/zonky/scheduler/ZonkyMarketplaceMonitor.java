package org.zhezhela.zonky.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.zhezhela.zonky.dto.ZonkyLoanDto;
import org.zhezhela.zonky.service.ZonkyApiService;

import java.util.List;

@Component
public class ZonkyMarketplaceMonitor {

    private Logger log = LoggerFactory.getLogger(ZonkyMarketplaceMonitor.class);

    @Autowired
    private ZonkyApiService zonkyApiService;

    @Scheduled(fixedDelayString = "${zonky.marketplace.monitor.delay:30000}")
    private void monitor() {
        List<ZonkyLoanDto> result = zonkyApiService.getLoans(null);
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(l -> log.info(l.toString()));
        }
    }

}
