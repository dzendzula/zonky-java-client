package org.zhezhela.zonky.dto;

import java.util.List;

public class ZonkyLoanMarketplaceDto {
    private List<ZonkyLoanDto> loans;

    public List<ZonkyLoanDto> getLoans() {
        return loans;
    }

    public void setLoans(List<ZonkyLoanDto> loans) {
        this.loans = loans;
    }
}
