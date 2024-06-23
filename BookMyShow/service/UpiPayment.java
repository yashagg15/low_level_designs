package BookMyShow.service;

public class UpiPayment extends Payment {

    public Integer transactionId = 0;

    @Override
    public String processBookingAmount(Double bookingAmount) {
        transactionId += 1;
        String tId = String.valueOf(transactionId);
        String transactionId = "TUPI" + tId;
        this.setTransactionId(transactionId);
        System.out.println("UPI of amount " + bookingAmount + " is completed");
        return transactionId;
    }
}
