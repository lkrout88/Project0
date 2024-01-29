package org.example.Service;
import org.example.Exception.BookServiceException;
import org.example.Exception.DeleteException;
import org.example.Model.BookEntry;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
public class BookService {

    List<BookEntry> books;

    public BookService() {
        books = new ArrayList<>();
    }

    /**
     * Add new book title to array list
     */
    public void addBookEntry(String title, String author, int rating) throws BookServiceException {
        Main.log.info("Attempt to add a book." + title + "," + author + "," + rating);

        if (rating < 1 || rating > 5) {
            Main.log.warn("throwing book exception due to wrong rating values: " + rating);
            throw new BookServiceException("Rating must be at least 1 and less than 5");
        } else if (title.length() < 1) {
            Main.log.warn("throwing book exception due to misformatted title" + title);
            throw new BookServiceException("title is blank");
        } else if (author.length() < 1) {
            Main.log.warn("throwing book exception due to misformatted author" + author);
            throw new BookServiceException("author is blank");
        }
        BookEntry b = new BookEntry(title, author, rating);
        books.add(b);


    }

    public List<BookEntry> getAllBooks() {
        return this.books;
    }

// search for book with a 5 rating


    public void deleteBookEntryTitle(String title) {

        books.removeIf(entry -> entry.getTitle().equals(title));

    }

    public BookEntry getBookByAuthor(String author) throws BookServiceException {
        if (author.length() < 1) {
            Main.log.warn("throwing book exception due to misformatted author" + author);
            throw new BookServiceException("author is blank");}
        for (int i = 0; i < books.size(); i = i + 1) {
            BookEntry currentBook = books.get(i);
            if (currentBook.getAuthor().equals(author)) {
                return currentBook;
            }
        }
        return null;
    }


    }
