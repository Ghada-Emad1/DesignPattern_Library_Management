package com;

public class BookFactory {

    public static BookInterface createBook(String type, String title, boolean isPremium) {
        BookInterface book;
        if (type.equalsIgnoreCase("ebook")) {
            book = new EBook(title);
            if (isPremium) {
                return new PremiumBookDecerator(book);
            }
            return book;
        } else if (type.equalsIgnoreCase("physical")) {
            return new PhysicalBook(title);
        } else if (type.equalsIgnoreCase("historical")) {
            return new HistoricalBook(title);
        } else {
            return new Book(title);
        }
    }
}
