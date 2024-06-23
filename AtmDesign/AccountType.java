package AtmDesign;

public enum AccountType {

    SAVINGS("SAVINGS"),
    CURRENT("CURRENT");

    String accountType;

     AccountType(String accountType){
        this.accountType = accountType;
    }
}
