package com.journalkeeper.service;

import com.journalkeeper.model.Journal;
import com.journalkeeper.repository.JournalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JournalService {

    private JournalRepository journalRepository;
    private List<Journal> journalList;

    public JournalService(JournalRepository journalRepository){
        this.journalList = new ArrayList<>();
        this.journalRepository = journalRepository;
        loadEntries();
    }

    public void addEntry(LocalDate date, String entry){
        journalList.add(new Journal(date, entry));
        Collections.sort(journalList); //sorting entry by descending of date, using natural order by implementing comparable interface
        saveEntries();
    }

    public List<Journal> getEntries(){
        return journalList;
    }

    private void loadEntries() {
        journalList.addAll(journalRepository.readAllEntries());
    }

    private void saveEntries(){
        journalRepository.saveAllEntries(journalList);
    }
}
