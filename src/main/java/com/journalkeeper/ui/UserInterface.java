package com.journalkeeper.ui;

import com.journalkeeper.JournalManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Path path;

    public UserInterface(Scanner scanner, Path path) {
        this.scanner = scanner;
        this.path = path;
    }

    public void start() {

        JournalManager journalManager = new JournalManager(path);

        while (true) {
            showMenu();
            String userInput = scanner.nextLine().trim();

            switch (userInput) {
                case "1":
                    handleAddEntry(journalManager);
                    break;
                case "2":
                    journalManager.printAllEntries();
                    break;
                case "3":
                    System.out.println("Exiting Journal Keeper. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid number.");
            }
        }
    }

    public void handleAddEntry(JournalManager journalManager) {
        try {
            System.out.println("Enter date (YYYY-MM-DD):");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.println("Enter your journal entry:");
            String entry = scanner.nextLine();

            journalManager.addEntry(date,entry);
            System.out.println("Entry added successfully!");

        }catch (Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void showMenu() {
        System.out.println("********* Journal Keeper *********");
        System.out.println("1. Add a new journal entry");
        System.out.println("2. View all journal entries");
        System.out.println("3. Exit");
        System.out.println("Please select an option (1-3):");
    }
}
