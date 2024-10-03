package com.journalkeeper.repository;

import com.journalkeeper.model.Journal;

import java.util.List;

public interface JournalRepository {
    List<Journal> readAllEntries();
    void saveAllEntries(List<Journal> journalList);

}
