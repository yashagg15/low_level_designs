package AtmDesign.States;

import AtmDesign.*;
import AtmDesign.BankingService.BankService;
import AtmDesign.Transaction.CheckBalanceTransaction;
import AtmDesign.Transaction.TransactionStatus;
import AtmDesign.Transaction.TransactionType;

public class CheckBalanceState implements AtmStates{

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("card already inserted");
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
        System.out.println("Pin already authenticated");
    }

    @Override
    public void executeTransactionForCheckBalance(ATM atm) {
        // To be implemented
        BankService bankService = atm.getBankService();
        Card card = atm.getCard();
        // get the account Id;
        Integer accountId = 2;
        Integer balance = bankService.checkBalance(accountId);
        CheckBalanceTransaction transaction = (CheckBalanceTransaction)  atm.getTransactions().get(atm.getTransactions().size()-1);
        System.out.println("Your current balance is "+balance);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        atm.setAtmStates(new IdleState());
    }

    @Override
    public void executeTransactionForWithdrawl(ATM atm, double amount) {
        System.out.println("this ops is not possible");
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
