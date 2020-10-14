package com.epam.task7.data;

import com.epam.task7.exceptions.DataException;

import java.util.List;

public interface DataReader {
    List<String> readLines() throws DataException;
}
