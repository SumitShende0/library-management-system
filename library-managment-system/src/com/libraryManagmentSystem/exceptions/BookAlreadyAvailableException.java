package com.libraryManagmentSystem.exceptions;

public class BookAlreadyAvailableException extends Exception{
    public BookAlreadyAvailableException(String message) {
        System.out.println(message);
    }
}
