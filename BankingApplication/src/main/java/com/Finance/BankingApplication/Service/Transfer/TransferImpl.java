package com.Finance.BankingApplication.Service.Transfer;

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
public class TransferImpl implements Transfer {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public SaveResponse saveTransferTransaction(TransferTransactionRequest transferTransactionRequest) {

        BankAccount senderAccount = bankAccountRepository.findById(transferTransactionRequest.getSenderAccountId()).get();
        BankAccount receiverAccount = bankAccountRepository.findById(transferTransactionRequest.getReceiverAccountId()).get();

        BigDecimal senderAvailableBalance = senderAccount.getAvailableBalance();
        BigDecimal receiverAvailableBalance = receiverAccount.getAvailableBalance();

        BigDecimal transferAmount = transferTransactionRequest.getAmountToTransfer();

        try {
            if ((senderAvailableBalance.compareTo(transferAmount) == 1)) {
                BigDecimal newSenderAvailableBalance = senderAvailableBalance.subtract(transferAmount);
                BigDecimal newReceiverAvailableBalance = receiverAvailableBalance.add(transferAmount);

                senderAccount.setAvailableBalance(newSenderAvailableBalance);
                receiverAccount.setAvailableBalance(newReceiverAvailableBalance);
            } else if ((senderAvailableBalance.compareTo(transferAmount) == 0)) {

                BigDecimal newSenderAvailableBalance = senderAvailableBalance.subtract(transferAmount);
                BigDecimal newReceiverAvailableBalance = receiverAvailableBalance.add(transferAmount);

                senderAccount.setAvailableBalance(newSenderAvailableBalance);
                receiverAccount.setAvailableBalance(newReceiverAvailableBalance);
            } else {
                System.out.println("you do not have the available balance to carry out transaction");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new SaveResponse(Boolean.TRUE, null);
    }
}
