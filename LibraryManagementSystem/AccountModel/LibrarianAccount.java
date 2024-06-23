package LibraryManagementSystem.AccountModel;

import LibraryManagementSystem.BookModel.BookItem;

import java.util.Map;

public class LibrarianAccount extends PersonAccount {

    Map<String, BookItem> barcodeIdVsBookItem;

    public LibrarianAccount(String personAccountId, String firstName, String emailAddress, String userName, String password,
                            LibraryCard libraryCard, Map<String, BookItem> barcodeIdVsBookItem) {
        super(personAccountId, firstName, emailAddress, userName, password, libraryCard);
        this.barcodeIdVsBookItem = barcodeIdVsBookItem;
    }


    public Map<String, BookItem> getBarcodeIdVsBookItem() {
        return barcodeIdVsBookItem;
    }

    public void setBarcodeIdVsBookItem(Map<String, BookItem> barcodeIdVsBookItem) {
        this.barcodeIdVsBookItem = barcodeIdVsBookItem;
    }

}
