package AtmDesign.States;

import AtmDesign.*;
import AtmDesign.BankingService.BankService;
import AtmDesign.BankingService.BankServiceFactory;
import AtmDesign.Transaction.TransactionType;

public class IdleState implements AtmStates{

    @Override
    public void insertCard(ATM atm, Card card) {
        boolean isCardValid = checkCardValidity(atm, card);
        if(isCardValid) {
            atm.setCard(card);
            atm.setAtmStates(new InsertCardState(card));
        }
    }

    @Override
    public void selectAccountType(ATM atm, AccountType accountType) {
        System.out.println("This ops is not possible");
    }

    @Override
    public void selectTransaction(ATM atm, TransactionType transactionType) {
        System.out.println("This ops is not possible");
    }

    @Override
    public void authenticatePin(ATM atm, int pin) {
        System.out.println("This ops is not possible");
    }

    @Override
    public void executeTransactionForCheckBalance(ATM atm) {
        System.out.println("Not allowed");
    }

    @Override
    public void executeTransactionForWithdrawl(ATM atm, double amount) {
        System.out.println("Not allowed");
    }

    @Override
    public void executeTransactionForDeposit(ATM atm, double amount) {
        System.out.println("Not allowed");
    }


    @Override
    public void cancelTransaction(ATM atm) {
        System.out.println("There is no running transaction in the system.");
    }

    public boolean checkCardValidity(ATM atm ,Card card){
        // Get the bank name after reading card details. Lets say it comes out to be HDFC
        String bankName = "HDFC";
        BankService bankService = BankServiceFactory.getBankService(bankName);
        atm.setBankService(bankService);
        return  bankService.validateCardAuthentication(card);
    }
}
