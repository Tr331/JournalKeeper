package com.journalkeeper.ui;

public interface UserInterface {
    void start();           // Start the UI (common to CLI and JavaFX)
    void addEntry();        // Handles adding an entry (triggered by a CLI input or a button in JavaFX)
    void display();
}
