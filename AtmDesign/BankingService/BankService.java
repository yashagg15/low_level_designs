package AtmDesign.BankingService;

import AtmDesign.Card;

public abstract class BankService {
    public abstract boolean validateCardAuthentication(Card card);

    public abstract boolean cardPinAuthenticate(Card card, int pin);

    public abstract Integer checkBalance(Integer accountId);

    public abstract void debitTransaction(Integer userAccountId, Integer amount);

    public abstract void creditTransaction(Integer userAccountId, Integer amount);
}
