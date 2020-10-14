package com.epam.task7.logic.creator;

import com.epam.task7.exceptions.DataException;

import java.util.List;

public interface Creator<T> {
    List<T> create() throws DataException;
}
