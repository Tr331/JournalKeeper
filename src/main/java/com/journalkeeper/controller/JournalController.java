package com.journalkeeper.controller;

import com.journalkeeper.model.Journal;
import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        return entries.stream()
                .map(Journal::toString)
                .collect(Collectors.joining("\n"));
    }

    public void printAllEntries() {
        System.out.println(getAllEntries());
    }

}
