package com.Finance.BankingApplication.Repository;

import com.Finance.BankingApplication.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wayne Sidney
 * Created on {09/05/2022}
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
