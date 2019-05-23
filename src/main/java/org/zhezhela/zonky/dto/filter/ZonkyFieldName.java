package org.zhezhela.zonky.dto.filter;

public enum ZonkyFieldName {
    ID("id"),
    URL("url"),
    NAME("name"),
    STORY("story"),
    PURPOSE("purpose"),
    NICKNAME("nickName"),
    TERMINMONTHS("termInMonths"),
    INTERESTRATE("interestRate"),
    REVENUERATE("revenueRate"),
    ANNUITYWITHINSURANCE("annuityWithInsurance"),
    RATING("rating"),
    TOPPED("topped"),
    AMOUNT("amount"),
    CURRENCY("currency"),
    REMAININGINVESTMENT("remainingInvestment"),
    RESERVEDAMOUNT("reservedAmount"),
    INVESTMENTRATE("investmentRate"),
    COVERED("covered"),
    DATEPUBLISHED("datePublished"),
    PUBLISHED("published"),
    DEADLINE("deadline"),
    INVESTMENTSCOUNT("investmentsCount"),
    QUESTIONSCOUNT("questionsCount"),
    REGION("region"),
    MAININCOMETYPE("mainIncomeType"),
    INSURANCEACTIVE("insuranceActive"),
    FIRSTAMOUNT("firstAmount"),
    TIMECREATED("timeCreated"),
    INVESTORID("investorId"),
    LOANID("loanId"),
    INVESTORNICKNAME("investorNickname"),
    STATUS("status"),
    ADDITIONALAMOUNT("additionalAmount");

    private final String name;

    ZonkyFieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
