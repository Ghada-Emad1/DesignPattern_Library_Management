package com;
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