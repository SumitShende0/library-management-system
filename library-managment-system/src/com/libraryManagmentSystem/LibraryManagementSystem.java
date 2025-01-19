package com.libraryManagmentSystem;

import com.libraryManagmentSystem.exceptions.BookAlreadyAvailableException;
import com.libraryManagmentSystem.exceptions.BookAlreadyIssuedException;
import com.libraryManagmentSystem.exceptions.BookNotFoundException;

import java.util.Scanner;

public class LibraryManagementSystem {
    private Services services;

    public LibraryManagementSystem() {
        services = new Services();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Display All Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Issue a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Delete a Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter Book Title: ");
                        String bookTitle = scanner.next();
                        System.out.print("Enter Author Name: ");
                        String bookAuthor = scanner.next();
                        services.addBook(new Book(bookId ,bookTitle, bookAuthor));
                        System.out.println("Book Added Successfully.");
                    }catch (IllegalArgumentException  | BookAlreadyAvailableException e){
                        e.getMessage();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;

                case 2:
                    services.displayAllBooks();
                    break;

                case 3:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.searchBook(bookId);

                    }catch (BookNotFoundException e){
                        e.getMessage();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;

                case 4:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.issueBook(bookId);
                        System.out.println("Book Issued successfully");
                    }catch (BookNotFoundException | BookAlreadyIssuedException e){
                        e.getMessage();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;

                case 5:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.returnBook(bookId);
                        System.out.println("Book Return successfully");
                    }catch (BookAlreadyAvailableException | BookNotFoundException e){
                        e.getMessage();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.removeBook(bookId);
                        System.out.println("Book Removed successfully");
                    }catch (BookNotFoundException | BookAlreadyIssuedException e){
                        e.getMessage();
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;

                case 7:
                    scanner.close();
                    break;

                default:
                    System.out.println("Enter valid option!!!");
            }
        }while (choice!=7);
    }
}
