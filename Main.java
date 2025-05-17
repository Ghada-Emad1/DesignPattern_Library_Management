package com;

import main.java.com.BookFactory;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        BookInterface book = BookFactory.createBook("default", "Harry Potter", false);
        BookInterface physicalBook = BookFactory.createBook("physical", "Lord of the Rings", false);
        BookInterface historicalBook = BookFactory.createBook("historical", "Outlander", false); 
        BookInterface premiumBook = BookFactory.createBook("ebook", "New Premium EBook", true); 

        library.addBook(book);
        library.addBook(physicalBook);
        library.addBook(historicalBook);  
        library.addBook(premiumBook);

        // Create users
        User john = new User("John", false);
        User alice = new User("Alice", true);

        // Test operations
        library.borrowBook("Harry Potter", john);
        System.out.println("\n=============================");
        library.returnBook("Harry Potter");

        System.out.println("=============================");
        library.borrowBook("Lord of the Rings", john);

        System.out.println("=============================");
        library.borrowBook("math", john); // Not in library
        library.returnBook("math");       // Not in library

        System.out.println("=============================");
        library.borrowBook("Lord of the Rings", alice);
        System.out.println("=============================");
        library.borrowBook("Outlander", alice);
        System.out.println("=============================");
        library.borrowBook("New Premium EBook", alice);
    }
}
