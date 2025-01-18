package com.libraryManagmentSystem;

import java.util.LinkedList;

public class Services {
    private static LinkedList<Book> booksList = new LinkedList<>();


    public void addBook(Book book){
        booksList.add(book);
    }

    public void removeBook(Book book){
        booksList.remove(book);
    }

    public void displayAllBooks(){
        System.out.println(booksList);
    }




}
