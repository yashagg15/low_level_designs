package LibraryManagementSystem.service;

import LibraryManagementSystem.BookModel.BookItem;
import LibraryManagementSystem.BookType;
import LibraryManagementSystem.Repository.BookRepository;

import java.util.List;

public class BookService {

    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBookItem(BookItem bookItem) {
        System.out.println("Adding book item");
        bookRepository.addBookItem(bookItem);
    }

    public BookItem deleteBookItem(String barcode) {
        // not implementing
        return null;
    }

    public BookItem updateBookItem(BookItem bookItem) {
        // not implementing
        return null;
    }

    public BookItem getBookById(String barcodeId) {
        return bookRepository.getBookById(barcodeId);
    }

    public List<BookItem> getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    public List<BookItem> getBookByAuthor(String authorName) {
        return bookRepository.getBookByAuthor(authorName);
    }

    public List<BookItem> getBookByType(BookType bookType) {
        return bookRepository.getBookByType(bookType);
    }

    public List<BookItem> getBookByPublicationDate(String publicationDate) {
        return bookRepository.getBookByPublicationDate(publicationDate);
    }

}
