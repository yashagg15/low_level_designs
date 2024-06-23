package BookMyShow.service;

public class PaymentFactory {


    public Payment getPaymentStrategy(String paymentType) {
        Payment payment = null;
        switch (paymentType) {
            case "UPI":
                payment = new UpiPayment();
                break;
            case "DEBIT":
                payment = new DebitCardPayment();
                break;
            default:
                payment = new CreditCardPayment();
        }
        return payment;
    }
}
