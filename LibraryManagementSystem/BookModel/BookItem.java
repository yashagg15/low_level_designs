package LibraryManagementSystem.BookModel;

import LibraryManagementSystem.AccountModel.Author;
import LibraryManagementSystem.AccountModel.PersonAccount;
import LibraryManagementSystem.BookStatus;
import LibraryManagementSystem.BookType;
import LibraryManagementSystem.Rack;

import java.util.Date;
import java.util.List;

public class BookItem extends Book {

    private String uniqueBarCode;
    private Date publicationDate;
    private Date issueDate;
    private Date dueDate;
    private Rack rack;
    private BookStatus bookStatus;

    private PersonAccount personAccount;


    public BookItem(String bookId, String bookTitle, BookType bookType, List<Author> authorsList,
                    String uniqueBarCode, Date publicationDate, Date issueDate, Date dueDate,
                    Rack rack, BookStatus bookStatus) {
        super(bookId, bookTitle, bookType, authorsList);
        this.uniqueBarCode = uniqueBarCode;
        this.publicationDate = publicationDate;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.rack = rack;
        this.bookStatus = bookStatus;
        this.personAccount = null;
    }

    public String getUniqueBarCode() {
        return uniqueBarCode;

    }

    public void setUniqueBarCode(String uniqueBarCode) {
        this.uniqueBarCode = uniqueBarCode;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public PersonAccount getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(PersonAccount personAccount) {
        this.personAccount = personAccount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "uniqueBarCode='" + uniqueBarCode + '\'' +
                ", publicationDate=" + publicationDate +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", rack=" + rack +
                ", bookStatus=" + bookStatus +
                ", personAccount=" + personAccount +
                '}';
    }
}
