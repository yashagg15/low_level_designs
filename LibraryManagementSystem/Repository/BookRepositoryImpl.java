package LibraryManagementSystem.Repository;

import LibraryManagementSystem.AccountModel.Author;
import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.BookType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {

    static Map<String, BookItem> bookBarCodeIdVsBookItem;
    static Map<String, List<BookItem>> bookTitleVsBookItem;
    static Map<String, List<BookItem>> bookAuthorNameVsBookItem;
    static Map<BookType, List<BookItem>> bookByTypeVsBookItem;
    static Map<String, List<BookItem>> bookByPublicationVsBookItem;

    static {
        bookBarCodeIdVsBookItem = new HashMap<>();
        bookTitleVsBookItem = new HashMap<>();
        bookAuthorNameVsBookItem = new HashMap<>();
        bookByTypeVsBookItem = new HashMap<>();
        bookByPublicationVsBookItem = new HashMap<>();
    }

    @Override
    public void addBookItem(BookItem bookItem) {

        String bookItemUniqueBarCodeId = bookItem.getUniqueBarCode();
        String bookTitle = bookItem.getBookTitle();
        List<Author> bookAuthorList = bookItem.getAuthorsList();
        BookType bookType = bookItem.getBookType();
        String date = bookItem.getPublicationDate().toString();

        bookBarCodeIdVsBookItem.put(bookItemUniqueBarCodeId, bookItem);

        if (bookTitleVsBookItem.get(bookTitle) == null) {
            bookTitleVsBookItem.put(bookTitle, new ArrayList<>());
        }
        bookTitleVsBookItem.get(bookTitle).add(bookItem);

        if (bookByTypeVsBookItem.get(bookType) == null) {
            bookByTypeVsBookItem.put(bookType, new ArrayList<>());
        }
        bookByTypeVsBookItem.get(bookType).add(bookItem);

        if (bookByPublicationVsBookItem.get(date) == null) {
            bookByPublicationVsBookItem.put(date, new ArrayList<>());
        }
        bookByPublicationVsBookItem.get(date).add(bookItem);

        bookAuthorList.stream().forEach(bookAuthor -> {

            if (bookAuthorNameVsBookItem.get(bookAuthor.getFirstName()) == null) {
                bookAuthorNameVsBookItem.put(bookAuthor.getFirstName(), new ArrayList<>());
            }
            bookAuthorNameVsBookItem.get(bookAuthor.getFirstName()).add(bookItem);
        });

    }

    @Override
    public BookItem deleteBookItem(String barcode) {
        // not implementing this
        return null;
    }

    @Override
    public BookItem updateBookItem(BookItem bookItem) {
        // not implementing this
        return null;
    }

    @Override
    public BookItem getBookById(String barCodeId) {
        return bookBarCodeIdVsBookItem.get(barCodeId);
    }

    @Override
    public List<BookItem> getBookByTitle(String title) {
        return bookTitleVsBookItem.get(title);
    }

    @Override
    public List<BookItem> getBookByAuthor(String authorName) {
        return bookAuthorNameVsBookItem.get(authorName);
    }

    @Override
    public List<BookItem> getBookByType(BookType bookType) {
        return bookByTypeVsBookItem.get(bookType);
    }

    @Override
    public List<BookItem> getBookByPublicationDate(String publicationDate) {
        return bookByPublicationVsBookItem.get(publicationDate);
    }
}
