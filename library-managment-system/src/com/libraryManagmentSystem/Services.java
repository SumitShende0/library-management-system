package com.libraryManagmentSystem;

import java.util.HashMap;
import java.util.LinkedList;

public class Services {
    private static LinkedList<Book> booksList = new LinkedList<>();
    private static HashMap<Integer, Book> booksMap = new HashMap<>();


    public static void addBook(Book book){
        booksList.add(book);
        booksMap.put(book.getBookId(), book);
    }

    public static void removeBook(int bookId){
        if (booksMap.containsKey(bookId)){
            Book bookToRemove = booksMap.remove(bookId);
            booksList.remove(bookToRemove);
        }

    }

    public static void displayAllBooks(){
        System.out.println(booksList);
    }




}
