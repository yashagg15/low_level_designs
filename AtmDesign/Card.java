package AtmDesign;

import java.util.Date;

public class Card {

    private String cardId;
    private int cvvCode;
    private Date expirationDate;
    private String username;
    private String cardNumber;
    private Integer cardPassword;

    public Card(String cardId, int cvvCode, Date expirationDate, String username, String cardNumber, Integer cardPassword) {
        this.cardId = cardId;
        this.cvvCode = cvvCode;
        this.expirationDate = expirationDate;
        this.username = username;
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(Integer cardPassword) {
        this.cardPassword = cardPassword;
    }
}
