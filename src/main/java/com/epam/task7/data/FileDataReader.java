package com.epam.task7.data;

import com.epam.task7.exceptions.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {
    private  String filename;
    public FileDataReader(String filename) {
        this.filename = filename;
    }

    public List<String> readLines() throws DataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = "";
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new DataException("Cannot read from file", e);
        }
    }
}
