package com.journalkeeper.ui;

import com.journalkeeper.controller.JournalController;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements UserInterface{
    private JournalController journalController;
    private Scanner scanner;

    public ConsoleUI(Scanner scanner, JournalController journalController) {
        this.scanner = scanner;
        this.journalController = journalController;
    }

    public void start() {

        while (true) {
            display();
            String userInput = scanner.nextLine().trim();

            switch (userInput) {
                case "1":
                    addEntry();
                    break;
                case "2":
                    journalController.printAllEntries();
                    break;
                case "3":
                    System.out.println("Exiting Journal Keeper. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid number.");
            }
        }
    }

    @Override
    public void addEntry() {
        try {
            System.out.println("Enter date (YYYY-MM-DD):");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.println("Enter your journal entry:");
            String entry = scanner.nextLine();

            journalController.addEntry(date,entry);
            System.out.println("Entry added successfully!");

        }catch (Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }

    @Override
    public void display() {
        System.out.println("********* Journal Keeper *********");
        System.out.println("1. Add a new journal entry");
        System.out.println("2. View all journal entries");
        System.out.println("3. Exit");
        System.out.println("Please select an option (1-3):");
    }
}
