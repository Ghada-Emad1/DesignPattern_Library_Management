package com;

public class PremiumBookDecerator implements BookInterface {

    private BookInterface decoratedBook;

    public PremiumBookDecerator(BookInterface book) {
        if (!(book instanceof EBook)) {
            throw new IllegalArgumentException("PremiumBook can only decorate EBooks");

        }
        this.decoratedBook = book;
    }

    @Override
    public void borrowBook(User user) {
        decoratedBook.borrowBook(user);
        System.out.println("Extra 10 days for borrow the book");
    }

    @Override
    public void returnBook() {
        decoratedBook.returnBook();
    }

    @Override
    public String getTitle() {
        return decoratedBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return decoratedBook.isAvailable();
    }

}
