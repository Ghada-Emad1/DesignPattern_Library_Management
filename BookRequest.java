package com;
public class BookRequest {
    private final User user;
    private final BookInterface book;
    private final int dayRequested;

    public BookRequest(User user,BookInterface book,int dayRequested){
        this.user=user;
        this.book=book;
        this.dayRequested=dayRequested;
    }

    BookInterface getBook(){
        return this.book;
    }

    User getUser(){
        return this.user;
    }
    public int getDaysRequested(){
        return this.dayRequested;
    }



}
