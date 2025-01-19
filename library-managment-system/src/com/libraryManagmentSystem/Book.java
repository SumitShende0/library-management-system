package com.libraryManagmentSystem;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookAvailabilityStatus;


    public Book(int bookId,String bookTitle, String bookAuthor) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookAvailabilityStatus = "Available";
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
