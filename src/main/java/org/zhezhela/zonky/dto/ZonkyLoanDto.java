package org.zhezhela.zonky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ZonkyLoanDto {

    private Long id;
    private String url;
    private String name;
    private String story;
    private String purpose;
    private List<ZonkyPhotoDto> photos;
    private String nickName;
    private Integer termInMonths;
    private BigDecimal interestRate;
    private BigDecimal revenueRate;
    private Integer annuityWithInsurance;
    private String rating;
    private Boolean topped;
    private BigDecimal amount;
    private String currency;
    private BigDecimal remainingInvestment;
    private BigDecimal reservedAmount;
    private BigDecimal investmentRate;
    private Boolean covered;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime datePublished;
    private Boolean published;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime deadline;
    private Integer investmentsCount;
    private Integer questionsCount;
    private String region;
    private String mainIncomeType;
    private Boolean insuranceActive;
    private List<ZonkyInsuranceHistoryItem> insuranceHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public List<ZonkyPhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ZonkyPhotoDto> photos) {
        this.photos = photos;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(Integer termInMonths) {
        this.termInMonths = termInMonths;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getRevenueRate() {
        return revenueRate;
    }

    public void setRevenueRate(BigDecimal revenueRate) {
        this.revenueRate = revenueRate;
    }

    public Integer getAnnuityWithInsurance() {
        return annuityWithInsurance;
    }

    public void setAnnuityWithInsurance(Integer annuityWithInsurance) {
        this.annuityWithInsurance = annuityWithInsurance;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Boolean getTopped() {
        return topped;
    }

    public void setTopped(Boolean topped) {
        this.topped = topped;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRemainingInvestment() {
        return remainingInvestment;
    }

    public void setRemainingInvestment(BigDecimal remainingInvestment) {
        this.remainingInvestment = remainingInvestment;
    }

    public BigDecimal getReservedAmount() {
        return reservedAmount;
    }

    public void setReservedAmount(BigDecimal reservedAmount) {
        this.reservedAmount = reservedAmount;
    }

    public BigDecimal getInvestmentRate() {
        return investmentRate;
    }

    public void setInvestmentRate(BigDecimal investmentRate) {
        this.investmentRate = investmentRate;
    }

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public ZonedDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(ZonedDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public ZonedDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(ZonedDateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getInvestmentsCount() {
        return investmentsCount;
    }

    public void setInvestmentsCount(Integer investmentsCount) {
        this.investmentsCount = investmentsCount;
    }

    public Integer getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionsCount = questionsCount;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMainIncomeType() {
        return mainIncomeType;
    }

    public void setMainIncomeType(String mainIncomeType) {
        this.mainIncomeType = mainIncomeType;
    }

    public Boolean getInsuranceActive() {
        return insuranceActive;
    }

    public void setInsuranceActive(Boolean insuranceActive) {
        this.insuranceActive = insuranceActive;
    }

    public List<ZonkyInsuranceHistoryItem> getInsuranceHistory() {
        return insuranceHistory;
    }

    public void setInsuranceHistory(List<ZonkyInsuranceHistoryItem> insuranceHistory) {
        this.insuranceHistory = insuranceHistory;
    }


    @Override
    public String toString() {
        return "Zonky Loan{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", purpose='" + purpose + '\'' +
                ", photos=[" + StringUtils.join(photos.stream().map(ZonkyPhotoDto::toString).collect(Collectors.toList()), ",") + "]" +
                ", nickName='" + nickName + '\'' +
                ", termInMonths=" + termInMonths +
                ", interestRate=" + interestRate +
                ", revenueRate=" + revenueRate +
                ", annuityWithInsurance=" + annuityWithInsurance +
                ", rating='" + rating + '\'' +
                ", topped=" + topped +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", remainingInvestment=" + remainingInvestment +
                ", reservedAmount=" + reservedAmount +
                ", investmentRate=" + investmentRate +
                ", covered=" + covered +
                ", datePublished=" + datePublished +
                ", published=" + published +
                ", deadline=" + deadline +
                ", investmentsCount=" + investmentsCount +
                ", questionsCount=" + questionsCount +
                ", region='" + region + '\'' +
                ", mainIncomeType='" + mainIncomeType + '\'' +
                ", insuranceActive=" + insuranceActive +
                ", insuranceHistory=[" + StringUtils.join(insuranceHistory.stream().map(ZonkyInsuranceHistoryItem::toString).collect(Collectors.toList()), ",") + "]" +
                '}';
    }
}
