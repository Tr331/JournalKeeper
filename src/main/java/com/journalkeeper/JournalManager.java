package com.journalkeeper;

import com.journalkeeper.repository.JournalFileRepository;
import com.journalkeeper.repository.JournalRepository;
import com.journalkeeper.service.JournalService;

import java.nio.file.Path;
import java.time.LocalDate;

public class JournalManager {
    private JournalService journalService;
    private JournalRepository journalRepository;

    public JournalManager(Path path){
        this.journalService = new JournalService();
        this.journalRepository = new JournalFileRepository(path);
        loadEntries();
    }

    public void addEntry(LocalDate date, String entry){
        journalService.addEntry(date,entry);
        saveEntries();
    }

    public void printAllEntries(){
        if (!(journalService.getEntries().isEmpty())){
            journalService.getEntries().forEach(System.out::println);
        }else {
            System.out.println("Journal file is empty. No entries to load.");
        }
    }

    private void loadEntries() {
        journalService.getEntries().addAll(journalRepository.readAllEntries());
    }

    public void saveEntries(){
        journalRepository.saveAllEntries(journalService.getEntries());
    }

}
