package LibraryManagementSystem;

import LibraryManagementSystem.BookModel.BookItem;

import java.util.Date;

public class Fine {

    private BookItem bookItem;
    private Date fineDate;
    private long exceededDays;
    private double finePrice;

    public Fine(BookItem bookItem, Date fineDate, long exceededDays, double finePrice) {
        this.bookItem = bookItem;
        this.fineDate = fineDate;
        this.exceededDays = exceededDays;
        this.finePrice = finePrice;
    }


    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }

    public long getExceededDays() {
        return exceededDays;
    }

    public void setExceededDays(long exceededDays) {
        this.exceededDays = exceededDays;
    }

    public double getFinePrice() {
        return finePrice;
    }

    public void setFinePrice(double finePrice) {
        this.finePrice = finePrice;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "bookItem=" + bookItem +
                ", fineDate=" + fineDate +
                ", exceededDays=" + exceededDays +
                ", finePrice=" + finePrice +
                '}';
    }

}
