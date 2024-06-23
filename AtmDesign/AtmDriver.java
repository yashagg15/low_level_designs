package AtmDesign;

import AtmDesign.Transaction.TransactionType;

import java.util.Date;
import java.util.Scanner;

public class AtmDriver {

    public static void main(String[] args) {
        String atmAddress = "Raj Nagar : Ghaziabad";
        String atmId = "1";
        ATM atm = new ATM(atmId, atmAddress);

        Card card = new Card("Card123",233, new Date(),"yash","46546543", 1677);

        System.out.println("---- Please insert your card for check balance transaction-----");

        atm.getAtmStates().insertCard(atm,card);

        Scanner sc= new Scanner(System.in);

        System.out.println("Please enter your pin");
        System.out.println();
        Integer pin = sc.nextInt();
        atm.getAtmStates().authenticatePin(atm,pin);
        TransactionType transactionType = TransactionType.CHECKBALANCE;
        atm.getAtmStates().selectTransaction(atm,transactionType);

        System.out.println("Executing the transaction");
        atm.getAtmStates().executeTransactionForCheckBalance(atm);

        System.out.println("---- Please insert your card for debit transaction-----");

        atm.getAtmStates().insertCard(atm,card);

        System.out.println("Please enter your pin");
        System.out.println();
        Scanner sc1= new Scanner(System.in);
        pin = sc1.nextInt();
        atm.getAtmStates().authenticatePin(atm,pin);
        transactionType = TransactionType.WITHDRAW;
        atm.getAtmStates().selectTransaction(atm,transactionType);

        System.out.println("Executing the transaction");
        atm.getAtmStates().executeTransactionForWithdrawl(atm, 400);

        System.out.println("---- Please insert your card for cash deposit  transaction-----");

        atm.getAtmStates().insertCard(atm,card);

        System.out.println("Please enter your pin");
        System.out.println();
        sc1= new Scanner(System.in);
        pin = sc1.nextInt();
        atm.getAtmStates().authenticatePin(atm,pin);
        transactionType = TransactionType.DEPOSIT;
        atm.getAtmStates().selectTransaction(atm,transactionType);

        System.out.println("Executing the transaction");
        atm.getAtmStates().executeTransactionForDeposit(atm, 78400);

        System.out.println("---- Please insert your card for debit transaction-----");

        atm.getAtmStates().insertCard(atm,card);

        System.out.println("Please enter your pin");
        System.out.println();
        sc1= new Scanner(System.in);
        pin = sc1.nextInt();
        atm.getAtmStates().authenticatePin(atm,pin);
        transactionType = TransactionType.WITHDRAW;
        atm.getAtmStates().selectTransaction(atm,transactionType);

        System.out.println("Executing the transaction");
        atm.getAtmStates().executeTransactionForWithdrawl(atm, 788400);

    }
}
