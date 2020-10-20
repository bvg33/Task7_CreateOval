package com.epam.task7.data.sort;

import com.epam.task7.model.ObservableOval;

import java.util.Comparator;

public class SorterByIdSpecification implements Comparator<ObservableOval> {

    @Override
    public int compare(ObservableOval firstOval, ObservableOval secondOval) {
        double firstOvalId= firstOval.getId();
        double secondOvalId= secondOval.getId();
        return firstOvalId > secondOvalId ? 1 :
                firstOvalId == secondOvalId ? 0 : -1;

    }
}
