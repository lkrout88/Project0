package org.example.View;


import org.example.Exception.BookServiceException;
import org.example.Exception.CLIException;
import org.example.Model.BookEntry;
import org.example.Service.BookService;

import java.util.List;
import java.util.Scanner;


public class CLIParser {
// not sure why I have this red dot

    BookService bookService;

    // is this instantiating the Book Service into the CLIParser?
    public CLIParser() {
        bookService = new BookService();
    }

    // add exceptions later
    public String parseCommandReturnOutput(String command) throws CLIException, BookServiceException {
        if (command.equals("add")) {
            return interpretAddAction();
        } else if (command.equals("view")) {
            return interpretViewAction();
        } else if (command.equals("delete")) {
            return interpretDeleteAction();
        } else if (command.equals("search")) {
            return interpretSearchAction();

//check that user made the correct entry
        } else throw new CLIException("not a valid entry");

    }
    // return command;


    public String interpretAddAction() throws BookServiceException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter book title:");
        String titleInput = sc.nextLine();
        System.out.println("Please enter author name:");
        String authorInput = sc.nextLine();
        System.out.println("Please enter book rating between 1 and 5 with 5 being the best");
        String ratingInputString = sc.nextLine();
        int rate = Integer.parseInt(ratingInputString);

        bookService.addBookEntry(titleInput, authorInput, rate);
        return "Book was added";
    }

    public String interpretViewAction() {
        List<BookEntry> books = bookService.getAllBooks();
        return "Here are your books: " + books.toString();
    }

    public String interpretDeleteAction() throws BookServiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter book title to delete");
        String remove = sc.nextLine();
        bookService.deleteBookEntryTitle(remove);
            return "Book was deleted";


    }
    public String interpretSearchAction() throws BookServiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an author to search");
        String authorInput = sc.nextLine();
        BookEntry matchingBook = bookService.getBookByAuthor(authorInput);
        if (matchingBook == null){
            return "There was no matching recipe found.";
        }else
        return "Here is a book by that author:" + matchingBook.toString();
    }


}


