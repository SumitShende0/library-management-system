package com.libraryManagmentSystem;

import com.libraryManagmentSystem.exceptions.BookNotFoundException;

import java.util.HashMap;
import java.util.LinkedList;

public class Services {
    private static LinkedList<Book> booksList = new LinkedList<>();
    private static HashMap<Integer, Book> booksMap = new HashMap<>();


    public static void addBook(Book book) throws IllegalArgumentException{
        if (book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (booksMap.containsKey(book.getBookId())){
            throw new IllegalArgumentException("Book Id: " + book.getBookId() + "is already exists");
        }
        booksList.add(book);
        booksMap.put(book.getBookId(), book);
    }

    public static void removeBook(int bookId) throws BookNotFoundException{
        if (!booksMap.containsKey(bookId)){
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        if (booksMap.get(bookId).getBookAvailabilityStatus() == "Issued"){
            throw new BookNotFoundException("Book with ID " + bookId + " is currently unavailable.");
        }

        Book bookToRemove = booksMap.remove(bookId);
        booksList.remove(bookToRemove);

    }

    public static void displayAllBooks(){
        System.out.println(booksList);
    }

    public static void searchBook(int bookId) throws BookNotFoundException{
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        System.out.println(booksMap.get(bookId));
    }

    public static void issueBook(int bookId) throws BookNotFoundException{
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        if (booksMap.get(bookId).getBookAvailabilityStatus() == "Issued"){
            throw new BookNotFoundException("Book with ID " + bookId + " already issued.");
        }
        booksMap.get(bookId).setBookAvailabilityStatus("Issued");
    }

    public static void returnBook(int bookId) throws BookNotFoundException{
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        if (booksMap.get(bookId).getBookAvailabilityStatus() == "Available"){
            throw new BookNotFoundException("Book with ID " + bookId + " already available.");
        }
        booksMap.get(bookId).setBookAvailabilityStatus("Available");
    }
}
