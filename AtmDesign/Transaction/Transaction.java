package AtmDesign.Transaction;

import AtmDesign.AccountType;

public abstract class Transaction {

    private String transactionId;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;
    private AccountType accountType;

    public Transaction(String transactionId, TransactionStatus transactionStatus, TransactionType transactionType, AccountType accountType) {
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.accountType = accountType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
