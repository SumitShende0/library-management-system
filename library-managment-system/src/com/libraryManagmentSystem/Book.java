package com.libraryManagmentSystem;

public class Book {
    private static int newBookId = 100;
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookAvailabilityStatus;


    public Book(String bookTitle, String bookAuthor, String bookAvailabilityStatus) {
        this.bookId = newBookId++;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookAvailabilityStatus() {
        return bookAvailabilityStatus;
    }

    public void setBookAvailabilityStatus(String bookAvailabilityStatus) {
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Book ID: " + bookId +
                ", Title: '" + bookTitle +
                ", Author: " + bookAuthor +
                ", Status: " + bookAvailabilityStatus;
    }
}
