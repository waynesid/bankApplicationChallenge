package com.Finance.BankingApplication.Service.Withdrawal;

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
public class WithdrawalTransactionImpl implements Withdrawal {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public SaveResponse withdrawTransaction(WithdrawalTransactionRequest request) {
        BankAccount account = bankAccountRepository.findById(request.getAccountId()).get();

        BigDecimal currentAvailableBalance = account.getAvailableBalance();
        BigDecimal withdrawalAmount = request.getWithdrawalAmount();

        try {
            if ((currentAvailableBalance.compareTo(withdrawalAmount)) == 1) {
                BigDecimal newAvailableBalance = currentAvailableBalance.subtract(withdrawalAmount);
                account.setAvailableBalance(newAvailableBalance);
            } else if ((currentAvailableBalance.compareTo(withdrawalAmount)) == 0) {
                BigDecimal newAvailableBalance = currentAvailableBalance.subtract(withdrawalAmount);
                account.setAvailableBalance(newAvailableBalance);
            } else {
                System.out.println("you do not have enough in the account to withdraw");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        bankAccountRepository.save(account);
        return new SaveResponse(Boolean.TRUE, null);
    }
}
