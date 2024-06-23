package BookMyShow.service;

public class CreditCardPayment extends Payment {

    public Integer transactionId = 0;

    @Override
    public String processBookingAmount(Double bookingAmount) {
        transactionId += 1;
        String tId = String.valueOf(transactionId);
        String transactionId = "TDebit" + tId;
        this.setTransactionId(transactionId);
        System.out.println("Debit of amount " + bookingAmount + " is completed via credit card");
        return transactionId;
    }
}
