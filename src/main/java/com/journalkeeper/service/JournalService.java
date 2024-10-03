package com.journalkeeper.service;

import com.journalkeeper.model.Journal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JournalService {
    private List<Journal> journalList;

    public JournalService(){
        this.journalList = new ArrayList<>();
    }

    public void addEntry(LocalDate date, String entry){
        journalList.add(new Journal(date, entry));
        Collections.sort(journalList); //sorting entry by descending of date, using natural order by implementing comparable interface
    }

    public List<Journal> getEntries(){
        return journalList;
    }
}
