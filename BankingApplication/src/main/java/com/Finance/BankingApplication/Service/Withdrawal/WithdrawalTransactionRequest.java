package com.Finance.BankingApplication.Service.Withdrawal;

import java.math.BigDecimal;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public class WithdrawalTransactionRequest {

    private Long accountId;

    private String name;

    private BigDecimal withdrawalAmount;

    public WithdrawalTransactionRequest() {
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

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
}
