package AtmDesign.States;

import AtmDesign.*;
import AtmDesign.BankingService.BankService;
import AtmDesign.Transaction.TransactionStatus;
import AtmDesign.Transaction.TransactionType;
import AtmDesign.Transaction.WithdrawBalanceTransaction;

public class WithDrawBalanceTransactionState implements AtmStates{


    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Ops not allowed");
    }

    @Override
    public void selectAccountType(ATM atm, AccountType accountType) {
        System.out.println("Ops not allowed");
    }

    @Override
    public void selectTransaction(ATM atm, TransactionType transactionType) {
        System.out.println("Ops not allowed");
    }

    @Override
    public void authenticatePin(ATM atm, int pin) {
        System.out.println("Ops not allowed");
    }

    @Override
    public void executeTransactionForCheckBalance(ATM atm) {
        System.out.println("this ops is not possible");
    }

    @Override
    public void executeTransactionForWithdrawl(ATM atm, double amount) {
        // To be implemented
        BankService bankService = atm.getBankService();
        Integer amountValue = (int) amount;
        WithdrawBalanceTransaction transaction = (WithdrawBalanceTransaction) atm.getTransactions().get(atm.getTransactions().size()-1);
        transaction.setTransactionAmount(amountValue);
        Card card = atm.getCard();
        // get the account Id;
        Integer accountId = 1;
        bankService.debitTransaction(accountId,amountValue);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        atm.setAtmStates(new IdleState());
    }

    @Override
    public void executeTransactionForDeposit(ATM atm, double amount) {
        System.out.println("this ops is not possible");
    }


    @Override
    public void cancelTransaction(ATM atm) {
        atm.setAtmStates(new IdleState());
    }
}
