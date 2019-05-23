package org.zhezhela.zonky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ZonkyInsuranceHistoryItem {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate policyPeriodFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate policyPeriodTo;

    public LocalDate getPolicyPeriodFrom() {
        return policyPeriodFrom;
    }

    public void setPolicyPeriodFrom(LocalDate policyPeriodFrom) {
        this.policyPeriodFrom = policyPeriodFrom;
    }

    public LocalDate getPolicyPeriodTo() {
        return policyPeriodTo;
    }

    public void setPolicyPeriodTo(LocalDate policyPeriodTo) {
        this.policyPeriodTo = policyPeriodTo;
    }

    @Override
    public String toString() {
        return "ZonkyInsuranceHistoryItem{" +
                "policyPeriodFrom=" + policyPeriodFrom +
                ", policyPeriodTo=" + policyPeriodTo +
                '}';
    }
}
