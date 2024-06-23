package AtmDesign.BankingService;

public class BankServiceFactory {


    public static BankService getBankService(String bankName){

        switch (bankName){
            case "HDFC":
                return new HDFCBankService();
            default:
                return new IDFCBankService();
        }
    }
}
