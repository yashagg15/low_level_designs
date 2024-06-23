package AtmDesign.States;

import AtmDesign.*;
import AtmDesign.BankingService.BankService;
import AtmDesign.Transaction.DepositTransaction;
import AtmDesign.Transaction.TransactionStatus;
import AtmDesign.Transaction.TransactionType;

public class CashDepositTransactionState implements AtmStates{


    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is already inserted");
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
        System.out.println("This ops not allowed");
    }

    @Override
    public void executeTransactionForWithdrawl(ATM atm, double amount) {
        System.out.println("this ops is not possible");
    }

    @Override
    public void executeTransactionForDeposit(ATM atm, double amount) {
        // To be implemented
        BankService bankService = atm.getBankService();
        Integer amountValue = (int) amount;
        Card card = atm.getCard();
        DepositTransaction transaction = (DepositTransaction) atm.getTransactions().get(atm.getTransactions().size()-1);
        transaction.setTransactionAmount(amountValue);
        // get the depositor account Id;
        Integer depositorAccountId = 5;
        bankService.creditTransaction(depositorAccountId,amountValue);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        atm.setAtmStates(new IdleState());
    }


    @Override
    public void cancelTransaction(ATM atm) {
        atm.setAtmStates(new IdleState());
    }
}
