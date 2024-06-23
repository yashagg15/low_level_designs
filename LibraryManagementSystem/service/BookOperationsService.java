package LibraryManagementSystem.service;

import LibraryManagementSystem.AccountModel.LibrarianAccount;
import LibraryManagementSystem.AccountModel.MemberAccount;
import LibraryManagementSystem.AccountModel.PersonAccount;
import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.BookStatus;
import LibraryManagementSystem.Constants;
import LibraryManagementSystem.Fine;

import java.util.Date;

public class BookOperationsService {

    private final FineService fineService;

    public BookOperationsService(FineService fineService) {
        this.fineService = fineService;
    }

    public boolean issueBook(BookItem bookItem, PersonAccount personAccount) {

        BookStatus bookStatus = bookItem.getBookStatus();
        MemberAccount memberAccount = null;
        LibrarianAccount librarianAccount = null;

        if (personAccount instanceof LibrarianAccount) {
            librarianAccount = (LibrarianAccount) personAccount;
        } else if (personAccount instanceof MemberAccount) {
            memberAccount = (MemberAccount) personAccount;
        }

        int bookIssuedByCustomers = memberAccount != null ? memberAccount.getBarcodeIdVsBookItem().size() : librarianAccount.getBarcodeIdVsBookItem().size();

        if ((bookStatus == BookStatus.AVAILABLE) && !(bookStatus == BookStatus.RENEWED && bookIssuedByCustomers < Constants.MAX_ISSUES_BOOKS_PER_ACCOUNT)) {
            if (bookStatus == BookStatus.ISSUED) {
                System.out.println("Book has been re issued to " + personAccount.getFirstName());
                bookItem.setBookStatus(BookStatus.RENEWED);
            } else {
                System.out.println("Book has been issued to " + personAccount.getFirstName());
                bookItem.setBookStatus(BookStatus.ISSUED);
            }
            bookItem.setIssueDate(new Date());
            Date dueDate = new Date();
            dueDate.setDate(bookItem.getIssueDate().getDate() + Constants.MAX_DAYS_TO_KEEP_A_BOOK);
            bookItem.setDueDate(dueDate);


            // update issued book in personal account
            if (personAccount instanceof LibrarianAccount) {
                librarianAccount.getBarcodeIdVsBookItem().put(bookItem.getUniqueBarCode(), bookItem);
            } else if (personAccount instanceof MemberAccount) {
                memberAccount.getBarcodeIdVsBookItem().put(bookItem.getUniqueBarCode(), bookItem);
            }
            bookItem.setPersonAccount(personAccount);
            return true;
        }
        System.out.println("Book can't be issued either it is issued multiple times or user has already reached its max limit to issue a book");
        return false;
    }

    public boolean returnBook(BookItem bookItem, PersonAccount personAccount) {

        checkFine(bookItem);
        if (bookItem.getBookStatus() == BookStatus.ISSUED) {
            System.out.println("Book has been returned to library ");
            bookItem.setBookStatus(BookStatus.AVAILABLE);
            bookItem.setIssueDate(null);
            bookItem.setDueDate(null);

            // update issued book in personal account
            if (personAccount instanceof LibrarianAccount) {
                LibrarianAccount librarianAccount = (LibrarianAccount) personAccount;
                librarianAccount.getBarcodeIdVsBookItem().remove(bookItem.getUniqueBarCode());
            } else if (personAccount instanceof MemberAccount) {
                MemberAccount memberAccount = (MemberAccount) personAccount;
                memberAccount.getBarcodeIdVsBookItem().remove(bookItem.getUniqueBarCode());
            }
            return true;
        }
        return false;
    }

    public boolean renewBook(BookItem bookItem, PersonAccount personAccount) {
        checkFine(bookItem);
        bookItem.setBookStatus(BookStatus.AVAILABLE);
        return issueBook(bookItem, personAccount);
    }

    public void checkFine(BookItem bookItem) {
        Fine fine = fineService.calculateFine(bookItem);
        if (fine == null)
            System.out.println(" No fine ");
        else {
            System.out.println("Fine details " + fine);
        }
    }

}
