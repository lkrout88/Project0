import org.example.Exception.BookServiceException;
import org.example.Model.BookEntry;
import org.example.Service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class BookServiceTest {

    BookService bookService;

    //Before the test set the service to a new object
    @Before
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void bookServiceEmptyAtStart() {
        List<BookEntry> bookEntryList = bookService.getAllBooks();
        Assert.assertTrue(bookEntryList.size() == 0);
    }

    @Test
    public void bookServiceAddBook() {
        String testTitle = "War and Peace";
        String testAuthor = "Tolstoy";
        int testRating = 2;

        try {
            bookService.addBookEntry(testTitle, testAuthor, testRating);

        } catch (BookServiceException x) {
            x.printStackTrace();
            Assert.fail("book service exception incorrectly  thrown");
        }

    }

    @Test
// test when incorrect rating is entered
    public void bookServiceIncorrectRating() {
        String title = "Outlander";
        String author = "Gabaldon";
        int rate = -1;
        try {
            bookService.addBookEntry(title, author, rate);
        } catch (BookServiceException e) {

        }

    }

    @Test
// test search by author function
    public void getBookByAuthor() {
        String testAuthor = "Galbaldon";
          try {
              bookService.getBookByAuthor(testAuthor);
          }catch (BookServiceException g) {
              g.printStackTrace();
              Assert.fail("book service exception incorrectly  thrown");
          }
    }

    @Test

    // test delete function
    public void deleteBookEntryTitle(){
        String testTitle = "Outlander";{
            bookService.deleteBookEntryTitle(testTitle);
        }


    }

}


