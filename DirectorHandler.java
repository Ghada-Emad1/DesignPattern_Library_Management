package com;
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
