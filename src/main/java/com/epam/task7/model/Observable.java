package com.epam.task7.model;

import com.epam.task7.data.observers.Observer;

public interface Observable {
    void addObserver(Observer observer);
}
