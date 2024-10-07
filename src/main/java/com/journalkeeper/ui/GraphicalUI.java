package com.journalkeeper.ui;

import com.journalkeeper.controller.JournalController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class GraphicalUI extends Application implements UserInterface{
    private static JournalController journalController;

    public static void setJournalController(JournalController controller) {
        journalController = controller;
    }

    @Override
    public void initialize(JournalController controller) {
        setJournalController(controller);
    }

    @Override
    public void show() {
        launch();
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Journal keeper");

        BorderPane layout = new BorderPane();

        Button addEntry = new Button("Add Entry");
        Button viewEntries = new Button("View Entries");

        HBox hBox = creatHbox(addEntry,viewEntries,layout);

        layout.setTop(hBox);

        ImageView imageView = getImageView();
        layout.setCenter(imageView);

        Scene scene = new Scene(layout,600,400);
        window.setScene(scene);
        window.show();
    }

    private ImageView getImageView() {
        Image image = new Image("file:Designer.png");

        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    public HBox creatHbox(Button addEntry, Button viewEntries, BorderPane layout){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setSpacing(10);

        addEntry.setOnAction(event -> {layout.setCenter(getAddEntry());});
        viewEntries.setOnAction(event -> layout.setCenter((getViewEntries())));

        hBox.getChildren().add(addEntry);
        hBox.getChildren().add(viewEntries);

        return hBox;
    }

    private Pane getViewEntries() {
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);

        String entries = journalController.getAllEntries();
        TextArea textArea = new TextArea(entries);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        layout.getChildren().add(scrollPane);
        return layout;
    }

    private Pane getAddEntry() {
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);

        Button addEntryButton = new Button("Add Entry");

        GridPane gridPane = getGridPane(addEntryButton);

        layout.getChildren().add(gridPane);

        return layout;
    }

    private GridPane getGridPane(Button addEntryButton) {

        GridPane layout = new GridPane();

        layout.setHgap(15);  // 15px space between columns
        layout.setVgap(10);  // 10px space between rows

        // Add padding around the GridPane
        layout.setPadding(new Insets(20, 20, 20, 20));

        layout.setAlignment(Pos.CENTER);

        Label date = new Label("Enter date (YYYY-MM-DD) ");
        TextField dateTextField = new TextField();

        dateTextField.setMaxWidth(150);

        Label entry = new Label("Enter your journal entry ");
        TextArea entryTextField = new TextArea();
        entryTextField.setPrefWidth(300);
        entryTextField.setPrefHeight(100);
        entryTextField.setStyle("-fx-font-size: 14px;");
        entryTextField.setWrapText(true);

        layout.add(date,0,0);
        layout.add(dateTextField,1,0);

        layout.add(entry,0,1);
        layout.add(entryTextField,1,1);

        layout.add(addEntryButton,1,2);

        addEntryButton.setOnAction(event -> {
            journalController.addEntry(LocalDate.parse(dateTextField.getText()),entryTextField.getText());
            dateTextField.clear();
            entryTextField.clear();
        });

        return layout;
    }


    private void addEntry(LocalDate date, String entry) {
//        if (date == null || entry.isEmpty()) {
//            showAlert("Error", "Please enter both date and entry.");
//            return;
//        }
//        journalController.addEntry(date, entry);
//        showAlert("Success", "Entry added successfully!");
    }

    private void showAlert(String title, String content) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(content);
//        alert.showAndWait();
    }

    @Override
    public void close() {
        // Implementation if needed
    }
}
