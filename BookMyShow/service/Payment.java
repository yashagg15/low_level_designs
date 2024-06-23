package BookMyShow.service;

public abstract class Payment {
    private String transactionId;

    public abstract String processBookingAmount(Double bookingAmount);

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                '}';
    }
}
