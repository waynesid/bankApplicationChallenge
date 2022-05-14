package com.Finance.BankingApplication.Service.Deposit;

import java.math.BigDecimal;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public class DepositTransactionRequest {

    private Long accountId;

    private String name;

    private BigDecimal depositAmount;


    public DepositTransactionRequest() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }
}
