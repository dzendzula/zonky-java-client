package org.zhezhela.zonky.dto;

import java.util.List;

public class ZonkyInvestmentListDto {
    private List<ZonkyInvestmentDto> investmentList;

    public List<ZonkyInvestmentDto> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<ZonkyInvestmentDto> investmentList) {
        this.investmentList = investmentList;
    }
}
