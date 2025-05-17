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

class ManagerHandler extends BookRequestHandler {
    @Override
    protected boolean canHandle(BookRequest request) {
        return request.getDaysRequested() > 7 && request.getDaysRequested() <= 14;
    }

    @Override
    protected void processRequest(BookRequest request) {
        System.out.println("Manager approves borrowing for " + request.getDaysRequested() + " days.");
        request.getBook().borrowBook(request.getUser());
    }
}

class DirectorHandler extends BookRequestHandler {
    @Override
    protected boolean canHandle(BookRequest request) {
        return request.getDaysRequested() > 14;
    }

    @Override
    protected void processRequest(BookRequest request) {
        System.out.println("Director approves borrowing for " + request.getDaysRequested() + " days.");
        request.getBook().borrowBook(request.getUser());
    }
}
