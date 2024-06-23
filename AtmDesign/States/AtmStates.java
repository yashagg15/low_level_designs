package AtmDesign.States;

import AtmDesign.ATM;
import AtmDesign.AccountType;
import AtmDesign.Card;
import AtmDesign.Transaction.TransactionType;

public interface AtmStates {
    void insertCard(ATM atm, Card card);
    void selectAccountType(ATM atm, AccountType accountType);
    void selectTransaction(ATM atm, TransactionType transactionType);
    void authenticatePin(ATM atm, int pin);
    void executeTransactionForCheckBalance(ATM atm);
    void executeTransactionForWithdrawl(ATM atm, double amount);
    void executeTransactionForDeposit(ATM atm, double amount);
    void cancelTransaction(ATM atm);

}
