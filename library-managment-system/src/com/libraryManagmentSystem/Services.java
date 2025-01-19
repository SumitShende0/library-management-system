package com.libraryManagmentSystem;

import com.libraryManagmentSystem.exceptions.BookAlreadyAvailableException;
import com.libraryManagmentSystem.exceptions.BookAlreadyIssuedException;
import com.libraryManagmentSystem.exceptions.BookNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Services {
    private static LinkedList<Book> booksList = new LinkedList<>();
    private static HashMap<Integer, Book> booksMap = new HashMap<>();



    public  void addBook(Book book) throws IllegalArgumentException, BookAlreadyAvailableException{
        if (book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (booksMap.containsKey(book.getBookId())){
            throw new BookAlreadyAvailableException("Book Id: " + book.getBookId() + "is already exists");
        }
        booksList.add(book);
        booksMap.put(book.getBookId(), book);
    }

    public  void removeBook(int bookId) throws BookNotFoundException, BookAlreadyIssuedException{
        if (!booksMap.containsKey(bookId)){
            throw new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        if (booksMap.get(bookId).getBookAvailabilityStatus() == "Issued"){
            throw new BookAlreadyIssuedException("Book with ID " + bookId + " is currently unavailable.");
        }

        Book bookToRemove = booksMap.remove(bookId);
        booksList.remove(bookToRemove);

    }

    public  void displayAllBooks(){

        System.out.println(booksList);
    }

    public  void searchBook(int bookId) throws BookNotFoundException{
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        System.out.println(booksMap.get(bookId));
    }

    public  void issueBook(int bookId) throws BookNotFoundException, BookAlreadyIssuedException {
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        Book book = booksMap.get(bookId);
        if (book.getBookAvailabilityStatus().equals("Issued")){
            throw new BookAlreadyIssuedException("Book with ID " + bookId + " already issued.");
        }
        book.setBookAvailabilityStatus("Issued");
    }

    public  void returnBook(int bookId) throws BookAlreadyAvailableException, BookNotFoundException {
        if(!booksMap.containsKey(bookId)){
            throw  new BookNotFoundException("Book with ID " + bookId + " not found.");
        }
        Book book = booksMap.get(bookId);
        if (book.getBookAvailabilityStatus().equals("Available")){
            throw new BookAlreadyAvailableException("Book with ID " + bookId + " already available.");
        }
        book.setBookAvailabilityStatus("Available");
    }
}
