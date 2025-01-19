package com.libraryManagmentSystem.exceptions;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String message) {
        System.out.println(message);
    }
}
