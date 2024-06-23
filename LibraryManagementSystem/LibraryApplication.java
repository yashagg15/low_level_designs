package LibraryManagementSystem;

import LibraryManagementSystem.AccountModel.*;
import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.Repository.BookRepository;
import LibraryManagementSystem.Repository.BookRepositoryImpl;
import LibraryManagementSystem.service.BookOperationsService;
import LibraryManagementSystem.service.BookService;
import LibraryManagementSystem.service.FineService;

import java.util.*;

public class LibraryApplication {

    public static Library getLibraryObject() {
        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookService(bookRepository);
        FineService fineService = new FineService();
        BookOperationsService bookOperationsService = new BookOperationsService(fineService);
        String libraryName = "Ashoka Learning Resource Center";
        String libAddress = "Raj Nagar";
        Library library = new Library(libraryName, libAddress, bookService, bookOperationsService);
        return library;
    }

    public static PersonAccount getMemberAccount() {
        String memberAccountId = "1";
        String firstName = "Yash";
        String emailAddress = "yash.agg";
        String userName = "username";
        String password = "12334";
        LibraryCard lc = new LibraryCard();
        int totalBooksCheckout = 0;
        Map<String, BookItem> barcodeIdVsBookItem = new HashMap<>();

        PersonAccount memberAccount = new MemberAccount(memberAccountId, firstName, emailAddress, userName,
                password, lc, totalBooksCheckout, barcodeIdVsBookItem);
        return memberAccount;
    }

    public static PersonAccount getLibrarianObject() {
        String librarianAccountId = "2";
        String l_firstName = "Akash";
        String l_emailAddress = "akash.agg";
        String l_userName = "username";
        String l_password = "34";
        LibraryCard l_lc = new LibraryCard();
        Map<String, BookItem> l_barcodeIdVsBookItem = new HashMap<>();

        PersonAccount librarianAccount = new LibrarianAccount(librarianAccountId, l_firstName, l_emailAddress, l_userName,
                l_password, l_lc, l_barcodeIdVsBookItem);
        return librarianAccount;

    }

    public static BookItem getBookItem() {
        String bookId = "book1";
        String bookTitle = "Stranger_Things";
        BookType bookType = BookType.SCI_FI;

        // author account building
        PersonAccount authorAccount = getAuthorObject();
        Author author = (Author) authorAccount;

        List<Author> authorsList = new ArrayList<>();
        authorsList.add(author);
        String uniqueBarCode = "BC1";
        Date publicationDate = new Date(2013, 10, 07);
        Date issueDate = null;
        Date dueDate = null;
        Rack rack = new Rack(1, "south-east-block");
        BookStatus bookStatus = BookStatus.AVAILABLE;


        BookItem bookItem = new BookItem(bookId, bookTitle, bookType, authorsList, uniqueBarCode, publicationDate,
                issueDate, dueDate, rack, bookStatus);
        return bookItem;
    }

    public static BookItem getBookItem2() {
        String bookId = "book2";
        String bookTitle = "Wild_Animals";
        BookType bookType = BookType.SCARY;

        // author account building
        PersonAccount authorAccount = getAuthorObject2();
        Author author = (Author) authorAccount;

        List<Author> authorsList = new ArrayList<>();
        authorsList.add(author);
        authorsList.add((Author) getAuthorObject()); // adding previous author also
        String uniqueBarCode = "BC3";
        Date publicationDate = new Date(2018, 8, 9);
        Date issueDate = null;
        Date dueDate = null;
        Rack rack = new Rack(1, "north-east-block");
        BookStatus bookStatus = BookStatus.AVAILABLE;


        BookItem bookItem = new BookItem(bookId, bookTitle, bookType, authorsList, uniqueBarCode, publicationDate,
                issueDate, dueDate, rack, bookStatus);
        return bookItem;
    }

    public static PersonAccount getAuthorObject() {
        String authorAccountId = "3";
        String a_firstName = "Rabindranath";
        String a_emailAddress = "Rabindranath";
        String a_userName = "username";
        String a_password = "334";
        LibraryCard a_lc = new LibraryCard();

        PersonAccount authorAccount = new Author(authorAccountId, a_firstName, a_emailAddress, a_userName,
                a_password, a_lc, new ArrayList<>());
        return authorAccount;

    }

    public static PersonAccount getAuthorObject2() {
        String authorAccountId = "6";
        String a_firstName = "Kaila DaGama";
        String a_emailAddress = "Kaila";
        String a_userName = "username";
        String a_password = "789";
        LibraryCard a_lc = new LibraryCard();

        PersonAccount authorAccount = new Author(authorAccountId, a_firstName, a_emailAddress, a_userName,
                a_password, a_lc, new ArrayList<>());
        return authorAccount;

    }

    public static void main(String[] args) {

        // Building a library Object
        Library library = getLibraryObject();

        // Building a member account object
        PersonAccount memberAccount = getMemberAccount();

        // Building a librarian account object
        PersonAccount librarianAccount = getLibrarianObject();

        // Building a book item-1
        BookItem bookItem1 = getBookItem();
        // Building a book item-2
        BookItem bookItem2 = getBookItem2();

        // member try to add book item.-- won't succeed
        library.addBookItem(bookItem1, memberAccount);

        // librarian trying to add book item -succeeded
        library.addBookItem(bookItem1, librarianAccount);
        library.addBookItem(bookItem2, librarianAccount);

        List<BookItem> bookItemList = library.getBookByAuthor("Rabindranath");
        bookItemList.stream().forEach(bookItemIns -> System.out.println(bookItemIns.toString()));

        List<BookItem> bookItemScary = library.getBookByType(BookType.SCARY);
        bookItemScary.stream().forEach(bookItemIns -> System.out.println(bookItemIns.toString()));

        BookItem bookItemIssued = library.issueBook("BC3", memberAccount);
        System.out.println(bookItemIssued.toString());
    }
}
