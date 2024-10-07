package com.journalkeeper.controller;

import com.journalkeeper.model.Journal;
import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService){
        this.journalService = journalService;
    }

    public void addEntry(LocalDate date, String entry){
        journalService.addEntry(date,entry);
    }

    public String getAllEntries() {
        List<Journal> entries = journalService.getEntries();
        if (entries.isEmpty()) {
            return "Journal is empty. No entries to display.";
        }
        StringBuilder sb = new StringBuilder();
        for (Journal entry : entries) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    public void printAllEntries() {
        System.out.println(getAllEntries());
    }

}
