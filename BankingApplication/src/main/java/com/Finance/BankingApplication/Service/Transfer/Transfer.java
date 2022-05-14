package com.Finance.BankingApplication.Service.Transfer;

import com.Finance.BankingApplication.Shared.SaveResponse;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public interface Transfer {

    SaveResponse saveTransferTransaction(TransferTransactionRequest transferTransactionRequest);
}
