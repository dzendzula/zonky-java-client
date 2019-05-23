package org.zhezhela.zonky.service;

import org.zhezhela.zonky.dto.ZonkyInvestmentListDto;
import org.zhezhela.zonky.dto.ZonkyLoanDto;
import org.zhezhela.zonky.dto.ZonkyLoanMarketplaceDto;
import org.zhezhela.zonky.dto.filter.ZonkyRequestParams;

import java.util.List;

public interface ZonkyApiService {

    /**
     * Get loans on marketplace.
     *
     * @return @{@link ZonkyLoanMarketplaceDto}
     */
    List<ZonkyLoanDto> getLoans(ZonkyRequestParams filter);

    /**
     * Single loan detail.
     *
     * @param loanId ID of loan to be viewed
     * @return Detail of @{@link ZonkyLoanDto}
     */
    ZonkyLoanDto getLoan(Integer loanId, ZonkyRequestParams params);

    /**
     * Get investmens for the loan.
     *
     * @param loanId ID of loan to be viewed
     * @return @{@link ZonkyInvestmentListDto}
     */
    ZonkyInvestmentListDto getLoanInvestments(Integer loanId, ZonkyRequestParams params);


}
