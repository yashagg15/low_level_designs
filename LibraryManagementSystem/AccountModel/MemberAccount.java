package LibraryManagementSystem.AccountModel;

import LibraryManagementSystem.BookModel.BookItem;

import java.util.Map;

public class MemberAccount extends PersonAccount {
    private int totalBooksCheckOut;
    Map<String, BookItem> barcodeIdVsBookItem;

    public MemberAccount(String personAccountId, String firstName, String emailAddress, String userName, String password, LibraryCard libraryCard, int totalBooksCheckOut, Map<String, BookItem> barcodeIdVsBookItem) {
        super(personAccountId, firstName, emailAddress, userName, password, libraryCard);
        this.totalBooksCheckOut = totalBooksCheckOut;
        this.barcodeIdVsBookItem = barcodeIdVsBookItem;
    }

    public int getTotalBooksCheckOut() {
        return totalBooksCheckOut;
    }

    public void setTotalBooksCheckOut(int totalBooksCheckOut) {
        this.totalBooksCheckOut = totalBooksCheckOut;
    }

    public Map<String, BookItem> getBarcodeIdVsBookItem() {
        return barcodeIdVsBookItem;
    }

    public void setBarcodeIdVsBookItem(Map<String, BookItem> barcodeIdVsBookItem) {
        this.barcodeIdVsBookItem = barcodeIdVsBookItem;
    }
}
