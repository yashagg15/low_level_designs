package AtmDesign.Transaction;

import AtmDesign.AccountType;

public class WithdrawBalanceTransaction extends Transaction {

    private Integer transactionAmount;

    public WithdrawBalanceTransaction(String transactionId, TransactionStatus transactionStatus,
                                      TransactionType transactionType, AccountType accountType,
                                      Integer transactionAmount) {
        super(transactionId, transactionStatus, transactionType, accountType);
        this.transactionAmount = transactionAmount;
    }


    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
