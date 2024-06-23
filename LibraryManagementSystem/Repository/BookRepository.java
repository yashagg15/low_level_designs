package LibraryManagementSystem.Repository;

import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.BookType;

import java.util.List;

public interface BookRepository {

    // add book items
    void addBookItem(BookItem bookItem);

    // delete book item
    BookItem deleteBookItem(String barcode);

    //update book item
    BookItem updateBookItem(BookItem bookItem);
    // All the search queries

    BookItem getBookById(String barcodeId);

    List<BookItem> getBookByTitle(String title);

    List<BookItem> getBookByAuthor(String authorName);

    List<BookItem> getBookByType(BookType bookType);

    List<BookItem> getBookByPublicationDate(String publicationDate);

}
