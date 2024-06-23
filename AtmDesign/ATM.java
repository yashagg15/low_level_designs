package AtmDesign;

import AtmDesign.BankingService.BankService;
import AtmDesign.BankingService.BankServiceFactory;
import AtmDesign.States.AtmStates;
import AtmDesign.States.IdleState;
import AtmDesign.Transaction.Transaction;
import AtmDesign.Transaction.TransactionFactory;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private String atmId;
    private String addresss;
    private AtmStates atmStates;
    private Card card;
    private List<Transaction> transactions;

    private BankService bankService;

    private TransactionFactory transactionFactory;

    private BankServiceFactory bankServiceFactory;

    public ATM(String atmId, String address) {
        this.atmId = atmId;
        this.addresss = address;
        this.atmStates = new IdleState();
        this.card = null;
        this.transactions = new ArrayList<>();
        this.bankService = null;
        this.transactionFactory = new TransactionFactory();
        this.bankServiceFactory = new BankServiceFactory();
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public AtmStates getAtmStates() {
        return atmStates;
    }

    public void setAtmStates(AtmStates atmStates) {
        this.atmStates = atmStates;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    public BankServiceFactory getBankServiceFactory() {
        return bankServiceFactory;
    }

    public void setBankServiceFactory(BankServiceFactory bankServiceFactory) {
        this.bankServiceFactory = bankServiceFactory;
    }
}
