package LibraryManagementSystem.AccountModel;

import LibraryManagementSystem.BookModel.Book;

import java.util.List;

public class Author extends PersonAccount {

    private List<Book> booksPublishedList;

    public Author(String personAccountId, String firstName, String emailAddress, String userName, String password, LibraryCard libraryCard, List<Book> booksPublishedList) {
        super(personAccountId, firstName, emailAddress, userName, password, libraryCard);
        this.booksPublishedList = booksPublishedList;
    }

    public List<Book> getBooksPublishedList() {
        return booksPublishedList;
    }

    public void setBooksPublishedList(List<Book> booksPublishedList) {
        this.booksPublishedList = booksPublishedList;
    }
}
