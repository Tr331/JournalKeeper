# JournalKeeper

**JournalKeeper** is a simple, modular Java application designed for storing, managing, and viewing personal journal entries. Built following SOLID design principles, the project is organized into clear layers, separating business logic, data persistence, and user interaction.

## 🌟 Features

- **📝 Add Journal Entries**: Create new entries with a specific date using a date picker in the JavaFX interface.
- **👀 View Entries**: Display entries in descending order by date in a neatly designed JavaFX table view.
- **💾 File-Based Storage**: Save and read entries from a file, ensuring persistence across application runs.
- **🏗️ Separation of Concerns**: Handle business logic, data storage, and user interaction in separate layers, adhering to SOLID principles.

## 🖼️ Preview

![image](https://github.com/user-attachments/assets/8e2898dc-0ba9-4d5f-85c5-65b1a45874f5)
![image](https://github.com/user-attachments/assets/e7e59c27-2b90-4d03-bad0-54447f2dcf1f)
![image](https://github.com/user-attachments/assets/5caa99b6-335b-4c9c-a21a-298724c7377b)


## 🛠️ Requirements

- Java 21 or higher
- JavaFX //In order to use gui
- Maven/Gradle (if using build tools)

## 🚀 Getting Started

### Clone the Repository:

```bash
git clone https://github.com/Tr331/JournalKeeper.git
cd JournalKeeper
```

### Compile and Run the Project:

#### Using Maven:

```bash
mvn javafx:run
```

#### Using Gradle:

```bash
./gradlew run
```

## 📱 Using the JavaFX Application

1. **Add Entry**: Click the "Add Entry" button to create a new journal entry.
2. **Select Date**: Choose a date from the date picker.
3. **Input Text**: Enter your journal text in the provided field.
4. **View Entries**: All stored journal entries are displayed in the JavaFX table.
5. **Clear Inputs**: Easily clear input fields after adding an entry.
6. **Exit**: Click the "Exit" button to close the application.

## 🔮 Future Enhancements

- **🗄️ Database Storage**: Implement support for database-backed storage, abstracting the repository layer for easy swapping between storage mechanisms.
- **🔍 Search Functionality**: Add the ability to search journal entries by keywords or date range.

## 📄 License

This project is licensed under the Apache 2.0 license.
