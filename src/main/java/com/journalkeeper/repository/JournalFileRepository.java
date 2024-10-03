package com.journalkeeper.repository;

import com.journalkeeper.model.Journal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalFileRepository implements JournalRepository {

    private Path path;

    public JournalFileRepository(Path path) {
        this.path = path;
    }

    @Override
    public List<Journal> readAllEntries() {
        List<Journal> journalList = new ArrayList<>();

        try {
            List<String> stringList = Files.readAllLines(path);
            Boolean checkIfFileHasEmptyEntries = stringList.stream().allMatch(String::isEmpty);

            if (!(stringList.isEmpty()||checkIfFileHasEmptyEntries)) {

                stringList.forEach(s -> {
                    String[] split = s.split(" : ");

                    LocalDate date = LocalDate.parse(split[0]);
                    String entry = split[1];

                    journalList.add(new Journal(date, entry));
                });
            }

        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }

        return journalList;
    }

    @Override
    public void saveALlEntries(List<Journal> journalList) {
        List<String> stringList = journalList.stream().map(Journal::toString).toList();

        try {
            Files.write(path, stringList);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
