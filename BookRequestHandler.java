package com;

public abstract class BookRequestHandler {
    private BookRequestHandler nextHandler;
    
    public void setNextHandler(BookRequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public void handleRequest(BookRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
    
    protected abstract boolean canHandle(BookRequest request);
    protected abstract void processRequest(BookRequest request);
}