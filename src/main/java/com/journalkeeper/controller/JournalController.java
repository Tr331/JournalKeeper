package com.journalkeeper.controller;

import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;

import java.nio.file.Path;
import java.time.LocalDate;

public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService){
        this.journalService = journalService;
    }

    public void addEntry(LocalDate date, String entry){
        journalService.addEntry(date,entry);
    }

    public void printAllEntries(){
        if (!(journalService.getEntries().isEmpty())){
            journalService.getEntries().forEach(System.out::println);
        }else {
            System.out.println("Journal file is empty. No entries to load.");
        }
    }

}
