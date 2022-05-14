package com.Finance.BankingApplication.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Wayne Sidney
 * Created on {09/05/2022}
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private Long transactionId;

    @Column(name = "transaction_amount")
    private Long transactionAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transacted_at", nullable = true, unique = false)
    private Date transactionTime;


    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @OneToOne
    @JoinColumn(name = "account_id")
    private BankAccount bankAccount;

    public Long getTransactionId() {
        return transactionId;
    }


    public Transaction() {
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
