package com.libraryManagmentSystem.exceptions;

public class BookAlreadyIssuedException extends Exception{
    public BookAlreadyIssuedException(String message) {
        System.out.println(message);
    }
}
