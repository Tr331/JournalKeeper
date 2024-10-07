package com.journalkeeper.ui;

import com.journalkeeper.controller.JournalController;

public interface UserInterface {
    void initialize(JournalController controller);
    void show();
    void close();
}
