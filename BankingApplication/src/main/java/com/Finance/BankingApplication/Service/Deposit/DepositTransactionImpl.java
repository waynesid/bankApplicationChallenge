package com.Finance.BankingApplication.Service.Deposit;

import com.Finance.BankingApplication.Entity.BankAccount;
import com.Finance.BankingApplication.Repository.BankAccountRepository;
import com.Finance.BankingApplication.Shared.SaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
@Service
public class DepositTransactionImpl implements Deposit {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public SaveResponse saveDepositTransaction(DepositTransactionRequest request) {
        BankAccount account = bankAccountRepository.findById(request.getAccountId()).get();

        BigDecimal currentAvailableBalance = account.getAvailableBalance();
        BigDecimal depositAmount = request.getDepositAmount();

        try {
            BigDecimal newBalance = currentAvailableBalance.add(depositAmount);
            account.setAvailableBalance(newBalance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bankAccountRepository.save(account);
        return new SaveResponse(Boolean.TRUE, null);
    }
}
