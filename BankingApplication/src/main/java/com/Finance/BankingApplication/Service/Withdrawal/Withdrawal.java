package com.Finance.BankingApplication.Service.Withdrawal;

import com.Finance.BankingApplication.Shared.SaveResponse;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public interface Withdrawal {
    SaveResponse withdrawTransaction(WithdrawalTransactionRequest request);
}
