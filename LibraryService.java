package com;

import java.util.ArrayList;
import java.util.List;

import main.java.com.BookRequest;
import main.java.com.BookRequestHandler;
import main.java.com.LibrarianHandler;

//applay singleton design pattern
public class LibraryService {

    private List<BookInterface> books = new ArrayList<>();
    private BookRequestHandler requestHandler;
    private static LibraryService instance;

    public LibraryService(){
        //set up chain responsibility design pattern
        LibrarianHandler librarian=new LibrarianHandler();
        ManagerHandler manager=new ManagerHandler();
        librarian.setNextHandler(manager);
        this.requestHandler=librarian;
    }

    //apply singleton that i can create only one object LibraryService
    public static LibraryService getInstance(){
        if(instance ==null){
            return new LibraryService();
        }
        return instance;
    }
    public void addBook(BookInterface book) {
        books.add(book);
    }

    private BookInterface findBook(String title) {
        for (BookInterface book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title, User user, int daysRequested) {
    BookInterface book = findBook(title);
    if (book == null) {
        System.out.println(title + " is not found in the library.");
    } else if (!book.isAvailable()) {
        System.out.println(title + " is not available.");
    } else {
        BookRequest request = new BookRequest(user, book, daysRequested);
        requestHandler.handleRequest(request);
    }
}


    public void returnBook(String title) {
        BookInterface book = findBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println(title+" is not found in the library.");
        }
    }
}
