package AtmDesign.Transaction;

import AtmDesign.AccountType;

public class CheckBalanceTransaction extends Transaction {


    public CheckBalanceTransaction(String transactionId, TransactionStatus transactionStatus, TransactionType transactionType, AccountType accountType) {
        super(transactionId, transactionStatus, transactionType, accountType);
    }

}
