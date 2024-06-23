package AtmDesign.BankingService;

import AtmDesign.Card;

import java.util.HashMap;
import java.util.Map;

public class HDFCBankService extends BankService {

    public  static Map<Integer,Integer> userAccountIdVsBalance;

    static {
        userAccountIdVsBalance = new HashMap<>();
        userAccountIdVsBalance.put(1,100000);
        userAccountIdVsBalance.put(2,90000);
        userAccountIdVsBalance.put(5,89000);
    }

    @Override
    public boolean validateCardAuthentication(Card card) {
        return true;
    }

    public boolean cardPinAuthenticate(Card card, int pin){
        return true;
    }

    @Override
    public Integer checkBalance(Integer accountId) {
        return userAccountIdVsBalance.get(accountId);
    }

    @Override
    public void debitTransaction(Integer userAccountId, Integer amount) {
        Integer currentBalance = userAccountIdVsBalance.get(userAccountId);
        System.out.println("Your balance before debit is "+userAccountIdVsBalance.get(userAccountId));
        if(currentBalance>=amount){
            userAccountIdVsBalance.put(userAccountId,userAccountIdVsBalance.get(userAccountId)-amount);
            System.out.println("Your new balance is "+userAccountIdVsBalance.get(userAccountId));
        }else {
            System.out.println("You dont have enough balance");
        }
    }

    @Override
    public void creditTransaction(Integer userAccountId, Integer amount) {
        System.out.println("Your balance before credit is "+userAccountIdVsBalance.get(userAccountId));
        userAccountIdVsBalance.put(userAccountId,userAccountIdVsBalance.get(userAccountId)+amount);
        System.out.println("Your balance after credit is "+userAccountIdVsBalance.get(userAccountId));
    }
}
