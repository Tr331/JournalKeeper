package com.journalkeeper.model;

import java.time.LocalDate;

public class Journal implements Comparable<Journal>{
    private LocalDate date;
    private String entry;

    public Journal(LocalDate date, String entry) {
        this.date = date;
        this.entry = entry;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEntry() {
        return entry;
    }

    @Override
    public String toString() {
        return this.getDate() + " : " + this.getEntry();
    }

    @Override
    public int compareTo(Journal o) {
        return o.getDate().compareTo(this.getDate());
    }
}
