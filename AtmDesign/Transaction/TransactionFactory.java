package AtmDesign.Transaction;

import AtmDesign.AccountType;

public class TransactionFactory {

    private static int transactionID = 0;

    public Transaction getNewTransaction(TransactionType transactionType, AccountType accountType){

        transactionID+=1;
        String tID = String.valueOf(transactionID);
        TransactionStatus transactionStatus = TransactionStatus.PROCESSING;

        switch (transactionType){
            case WITHDRAW:
                return new WithdrawBalanceTransaction(tID,transactionStatus, transactionType,accountType,0);
            case DEPOSIT:
                return new DepositTransaction(tID,transactionStatus, transactionType,accountType,0);
            default:
                return new CheckBalanceTransaction(tID, transactionStatus, transactionType, accountType);
        }
    }
}
