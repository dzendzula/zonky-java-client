package org.zhezhela.zonky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ZonkyInvestmentDto {

    private Long id;
    private BigDecimal firstAmount;
    private BigDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime timeCreated;
    private Long investorId;
    private Long loanId;
    private String investorNickname;
    private String status;
    private BigDecimal additionalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(BigDecimal firstAmount) {
        this.firstAmount = firstAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ZonedDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(ZonedDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getInvestorNickname() {
        return investorNickname;
    }

    public void setInvestorNickname(String investorNickname) {
        this.investorNickname = investorNickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(BigDecimal additionalAmount) {
        this.additionalAmount = additionalAmount;
    }

    @Override
    public String toString() {
        return "ZonkyInvestmentDto{" +
                "id=" + id +
                ", firstAmount=" + firstAmount +
                ", amount=" + amount +
                ", timeCreated=" + timeCreated +
                ", investorId=" + investorId +
                ", loanId=" + loanId +
                ", investorNickname='" + investorNickname + '\'' +
                ", status='" + status + '\'' +
                ", additionalAmount=" + additionalAmount +
                '}';
    }
}
