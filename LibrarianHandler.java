package com;
public class LibrarianHandler extends BookRequestHandler {
    @Override
    protected boolean canHandle(BookRequest request) {
        return request.getDaysRequested() <= 7;
    }

    @Override
    protected void processRequest(BookRequest request) {
        System.out.println("Librarian approves borrowing for " + request.getDaysRequested() + " days.");
        request.getBook().borrowBook(request.getUser());
    }
}


