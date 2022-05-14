package com.Finance.BankingApplication;

import com.Finance.BankingApplication.Service.Deposit.Deposit;
import com.Finance.BankingApplication.Service.Deposit.DepositTransactionRequest;
import com.Finance.BankingApplication.Service.Transfer.Transfer;
import com.Finance.BankingApplication.Service.Transfer.TransferTransactionRequest;
import com.Finance.BankingApplication.Service.Withdrawal.Withdrawal;
import com.Finance.BankingApplication.Service.Withdrawal.WithdrawalTransactionRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class BankingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BankingApplication.class, args);
        Withdrawal withdrawalService = context.getBean(Withdrawal.class);
        Deposit depositService = context.getBean(Deposit.class);
        Transfer transferService = context.getBean(Transfer.class);


        String path = "src/main/resources/Input Text.txt";
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(":",4);
                //for (String s : values) {}
                List<String> set = new ArrayList<>(List.of(values));
                switch (set.get(0).toLowerCase()) {
                    case "withdraw" -> {
                        String name = set.get(1);
                        String withdrawalAmount = set.get(2);
                        BigDecimal withdrawalAmount2 = new BigDecimal(withdrawalAmount);
                        WithdrawalTransactionRequest withdrawalTransactionRequest = new WithdrawalTransactionRequest();
                        if (Objects.equals(name, "Wanjiru")) {
                            withdrawalTransactionRequest.setAccountId(1L);

                        } else if (Objects.equals(name, "Juma")) {
                            withdrawalTransactionRequest.setAccountId(2L);
                        } else if (Objects.equals(name, "Linda")) {
                            withdrawalTransactionRequest.setAccountId(3L);
                        } else {
                            System.out.println("no such user");
                        }
                        withdrawalTransactionRequest.setName(name);
                        withdrawalTransactionRequest.setWithdrawalAmount(withdrawalAmount2);
                        withdrawalService.withdrawTransaction(withdrawalTransactionRequest);
                    }
                    case "deposit" -> {
                        String depositName = set.get(1);
                        String depositAmount = set.get(2);
                        BigDecimal depositAmount2 = new BigDecimal(depositAmount);
                        DepositTransactionRequest depositTransactionRequest = new DepositTransactionRequest();
                        if (Objects.equals(depositName, "Wanjiru")) {
                            depositTransactionRequest.setAccountId(1L);

                        } else if (Objects.equals(depositName, "Juma")) {
                            depositTransactionRequest.setAccountId(2L);
                        } else if (Objects.equals(depositName, "Linda")) {
                            depositTransactionRequest.setAccountId(3L);
                        } else {
                            System.out.println("no such user");

                        }
                        depositTransactionRequest.setName(depositName);
                        depositTransactionRequest.setDepositAmount(depositAmount2);
                        depositService.saveDepositTransaction(depositTransactionRequest);
                    }
                    case "transfer" -> {
                        String senderName = set.get(1);
                        String receiverName = set.get(2);
                        String transferAmount = set.get(3);
                        BigDecimal transferAmount2 = new BigDecimal(transferAmount);
                        TransferTransactionRequest transferTransactionRequest = new TransferTransactionRequest();
                        if (Objects.equals(senderName, "Wanjiru")) {
                            transferTransactionRequest.setSenderAccountId(1L);

                        } else if (Objects.equals(senderName, "Juma")) {
                            transferTransactionRequest.setSenderAccountId(2L);
                        } else if (Objects.equals(senderName, "Linda")) {
                            transferTransactionRequest.setSenderAccountId(3L);
                        } else {
                            System.out.println("no such user");
                        }
                        if (Objects.equals(receiverName, "Wanjiru")) {
                            transferTransactionRequest.setReceiverAccountId(1L);

                        } else if (Objects.equals(receiverName, "Juma")) {
                            transferTransactionRequest.setReceiverAccountId(2L);
                        } else if (Objects.equals(receiverName, "Linda")) {
                            transferTransactionRequest.setReceiverAccountId(3L);
                        } else {
                            System.out.println("no such user");
                        }
                        transferTransactionRequest.setSenderName(senderName);
                        transferTransactionRequest.setReceiverName(receiverName);
                        transferTransactionRequest.setAmountToTransfer(transferAmount2);
                        transferService.saveTransferTransaction(transferTransactionRequest);
                    }
                }
                System.out.println(set);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
