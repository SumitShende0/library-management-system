package com.libraryManagmentSystem;

import com.libraryManagmentSystem.exceptions.BookAlreadyAvailableException;
import com.libraryManagmentSystem.exceptions.BookAlreadyIssuedException;
import com.libraryManagmentSystem.exceptions.BookNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
    private Services services;

    public LibraryManagementSystem() {
        services = new Services();
    }

    public void displayMenu(){
        System.out.println("Library Management System");
        System.out.println("1. Add a book");
        System.out.println("2. Display All Book");
        System.out.println("3. Search for a Book");
        System.out.println("4. Issue a Book");
        System.out.println("5. Return a Book");
        System.out.println("6. Delete a Book");
        System.out.println("7. Exit");
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            displayMenu();
            try {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.nextLine();
            }catch (Exception e){
            }

            switch (choice){
                case 1:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.bookAvailable(bookId);
                        System.out.print("Enter Book Title: ");
                        scanner.nextLine();
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter Author Name: ");
                        String bookAuthor = scanner.nextLine();
                        services.addBook(new Book(bookId ,bookTitle, bookAuthor));
                        System.out.println("Book Added Successfully.");
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter proper input value!!!");
                        scanner.nextLine();
                    }
                    catch (Exception e){
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

                    }catch (InputMismatchException e){
                        System.out.println("Please Enter proper input value!!!");
                        scanner.nextLine();
                    }
                    catch (Exception e){
                    }
                    break;

                case 4:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.issueBook(bookId);
                        System.out.println("Book Issued successfully");
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter proper input value!!!");
                        scanner.nextLine();
                    }
                    catch (Exception e){
                    }
                    break;

                case 5:
                    try{
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.returnBook(bookId);
                        System.out.println("Book Return successfully");
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter proper input value!!!");
                        scanner.nextLine();
                    }
                    catch (Exception e){
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        services.removeBook(bookId);
                        System.out.println("Book Removed successfully");
                    }catch (InputMismatchException e){
                        System.out.println("Please Enter proper input value!!!");
                        scanner.nextLine();
                    }
                    catch (Exception e){
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
