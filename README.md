# JournalKeeper

JournalKeeper is a simple, modular Java application designed for storing, managing, and viewing personal journal entries. Built following SOLID design principles, the project is organized into clear layers, separating business logic, data persistence, and user interaction. The current version uses a command-line interface (CLI) for interacting with the journal, but it is structured for easy future extension to a graphical interface using JavaFX.

## Features

- **Add Journal Entries**: Users can add new journal entries with a specific date.
- **View Entries**: Entries are stored and displayed in descending order by date.
- **File-Based Storage**: Entries are saved to and read from a file, making them persistent across application runs.
- **Separation of Concerns**: Business logic, data storage, and user interaction are handled in separate layers, adhering to SOLID principles.

## Preview
![image](https://github.com/user-attachments/assets/d5d82e8c-191e-43c7-981b-ec2f663cb43d)
![image](https://github.com/user-attachments/assets/bf29ad87-ad05-4cc2-85e4-4e8f616ef62f)
![image](https://github.com/user-attachments/assets/dd56bdf7-fa8c-4236-9731-65e612fe6d50)

## Requirements

- **Java 21** or higher
- **Maven/Gradle** (if you prefer build tools)

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Tr331/JournalKeeper.git

    Navigate to the Project Directory:

    bash

cd JournalKeeper

Compile and Run the Project: Use the following command to compile and run:

bash

    javac -d bin src/main/java/com/journalkeeper/App.java
    java -cp bin com.journalkeeper.App

    Using the CLI:
        Press 1 to add a journal entry.
        Press 2 to view all stored entries.
        Press 3 to exit the application.

Future Enhancements

    JavaFX Interface: Plan to transition from a CLI to a JavaFX graphical user interface - Completed
    Database Storage: Future versions could include support for database-backed storage, abstracting the repository layer for easy swapping between storage mechanisms.
    Search Functionality: Add the ability to search journal entries by keywords or date range.

License

This project is licensed under the apache 2.0 license - see the LICENSE file for details.
