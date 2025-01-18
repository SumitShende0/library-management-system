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



}
