package com.Finance.BankingApplication.Repository;

import com.Finance.BankingApplication.Entity.BankAccount;
import com.Finance.BankingApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wayne Sidney
 * Created on {09/05/2022}
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
