package LibraryManagementSystem;

import LibraryManagementSystem.AccountModel.LibrarianAccount;
import LibraryManagementSystem.AccountModel.PersonAccount;
import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.service.BookOperationsService;
import LibraryManagementSystem.service.BookService;

import java.util.List;

public class Library {
    private String name;
    private String address;
    private BookOperationsService bookOperationsService;
    private BookService bookService;

    public Library(String name, String address, BookService bookService,
                   BookOperationsService bookOperationsService) {
        this.name = name;
        this.address = address;
        this.bookService = bookService;
        this.bookOperationsService = bookOperationsService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public BookOperationsService getBookOperationsService() {
        return bookOperationsService;
    }

    public void setBookOperationsService(BookOperationsService bookOperationsService) {
        this.bookOperationsService = bookOperationsService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookItem getBookById(String barCodeId) {
        return bookService.getBookById(barCodeId);
    }

    public List<BookItem> getBookByTitle(String title) {
        return bookService.getBookByTitle(title);
    }

    public List<BookItem> getBookByAuthor(String authorName) {
        return bookService.getBookByAuthor(authorName);
    }

    public List<BookItem> getBookByType(BookType bookType) {
        return bookService.getBookByType(bookType);
    }

    public List<BookItem> getBookByPublicationDate(String publicationDate) {
        return bookService.getBookByPublicationDate(publicationDate);
    }

    public void addBookItem(BookItem bookItem, PersonAccount personAccount) {
        if (personAccount instanceof LibrarianAccount) {
            System.out.println("Book was added by " + personAccount.getFirstName());
            bookService.addBookItem(bookItem);
        } else {
            System.out.println("Only admin can add the books in the library");
        }
    }

    public BookItem deleteBookItem(String barcode) {
        // not implementing. just call book service. same validation in addBookItem
        return null;
    }

    public BookItem updateBookItem(BookItem bookItem) {
        // not implementing. just call book service. same validation in addBookItem
        return null;
    }


    public BookItem issueBook(String barcodeId, PersonAccount personAccount) {

        BookItem bookItem = bookService.getBookById(barcodeId);
        bookOperationsService.issueBook(bookItem, personAccount);
        return bookItem;
    }

    public BookItem returnBook(String barcodeId, PersonAccount personAccount) {
        BookItem bookItem = bookService.getBookById(barcodeId);
        bookOperationsService.returnBook(bookItem, personAccount);
        return bookItem;

    }

    public BookItem renewBook(String barCodeId, PersonAccount personAccount) {
        BookItem bookItem = bookService.getBookById(barCodeId);
        bookOperationsService.renewBook(bookItem, personAccount);
        return bookItem;
    }


}
