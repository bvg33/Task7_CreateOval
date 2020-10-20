package com.epam.task7.data.sort;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;

import java.util.Comparator;

public class SorterByAreaSpecification implements Comparator<ObservableOval> {
    @Override
    public int compare(ObservableOval firstOval, ObservableOval secondOval) {
        OvalParameters firstOvalParameters=firstOval.getParameters();
        OvalParameters secondOvalParameters=secondOval.getParameters();
        double firstOvalArea= firstOvalParameters.getArea();
        double secondOvalArea= secondOvalParameters.getArea();
        return firstOvalArea > secondOvalArea ? 1 :
                firstOvalArea == secondOvalArea ? 0 : -1;
    }
}
