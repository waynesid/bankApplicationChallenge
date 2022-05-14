package com.Finance.BankingApplication.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Wayne Sidney
 * Created on {09/05/2022}
 */

@Entity
@Table(name = "account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bankAccount")
    private User user;


    @Column(name = "availableBalance", nullable = false)
    private BigDecimal availableBalance;

    public BankAccount() {
    }

    public BankAccount(Long accountId, User user, BigDecimal availableBalance) {
        this.accountId = accountId;
        this.user = user;
        this.availableBalance = availableBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(availableBalance, account.availableBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, availableBalance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", availableBalance=" + availableBalance +
                '}';
    }
}
