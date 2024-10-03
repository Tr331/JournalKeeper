package com.journalkeeper.repository;

import com.journalkeeper.model.Journal;

import java.util.List;

public interface JournalRepository {
    List<Journal> readAllEntries();
    void saveALlEntries(List<Journal> journalList);

}
