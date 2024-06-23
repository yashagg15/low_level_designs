package LibraryManagementSystem.AccountModel;

import java.util.Date;

public class LibraryCard {

    private Integer cardId;
    private Date cardIssued;
    private Date cardValidityDate;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Date getCardIssued() {
        return cardIssued;
    }

    public void setCardIssued(Date cardIssued) {
        this.cardIssued = cardIssued;
    }

    public Date getCardValidityDate() {
        return cardValidityDate;
    }

    public void setCardValidityDate(Date cardValidityDate) {
        this.cardValidityDate = cardValidityDate;
    }
}
