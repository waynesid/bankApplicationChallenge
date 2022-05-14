package com.Finance.BankingApplication.Service.Deposit;

import com.Finance.BankingApplication.Shared.SaveResponse;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public interface Deposit {

    SaveResponse saveDepositTransaction(DepositTransactionRequest request);


}
