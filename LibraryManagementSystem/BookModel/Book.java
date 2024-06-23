package LibraryManagementSystem.BookModel;

import LibraryManagementSystem.AccountModel.Author;
import LibraryManagementSystem.BookType;

import java.util.List;

public abstract class Book {

    private String bookId;
    private String bookTitle;
    private BookType bookType;
    private List<Author> authorsList;

    public Book(String bookId, String bookTitle, BookType bookType, List<Author> authorsList) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookType = bookType;
        this.authorsList = authorsList;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookType=" + bookType +
                ", authorsList=" + authorsList +
                '}';
    }
}
