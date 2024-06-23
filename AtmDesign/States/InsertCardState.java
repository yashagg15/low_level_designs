package AtmDesign.States;

import AtmDesign.*;
import AtmDesign.BankingService.BankService;
import AtmDesign.Transaction.Transaction;
import AtmDesign.Transaction.TransactionType;


public class InsertCardState implements AtmStates{

    private Card card;
    private AccountType accountType;
    private TransactionType transactionType;

    public InsertCardState(Card card){
        this.card = card;
    }
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is already inserted");
    }

    @Override
    public void selectAccountType(ATM atm, AccountType accountType) {
        setAccountType(accountType);
    }

    @Override
    public void selectTransaction(ATM atm, TransactionType transactionType) {
        setTransactionType(transactionType);
        Transaction transaction = atm.getTransactionFactory().getNewTransaction(transactionType, accountType);
        atm.getTransactions().add(transaction);
        setTransactionState(atm, transactionType);
    }

    @Override
    public void authenticatePin(ATM atm, int pin) {
        BankService bankService = atm.getBankService();
        Card card = atm.getCard();
        boolean pinAuthentication = bankService.cardPinAuthenticate(card,pin);
        if(pinAuthentication)
            System.out.println("Pin is authenticated");
        else {
            atm.setAtmStates(new IdleState());
            System.out.println("Please insert your card again");
        }

    }

    @Override
    public void executeTransactionForCheckBalance(ATM atm) {
        System.out.println("this ops is not possible");
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }


    public void setTransactionState(ATM atm, TransactionType transactionType){
        switch (transactionType){
            case WITHDRAW:
                atm.setAtmStates(new WithDrawBalanceTransactionState());
                break;
            case DEPOSIT:
                atm.setAtmStates(new CashDepositTransactionState());
                break;
            default:
                atm.setAtmStates(new CheckBalanceState());

        }
    }
}
