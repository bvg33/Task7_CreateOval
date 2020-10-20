package com.epam.task7.data.sort;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;

import java.util.Comparator;

public class SorterByPerimeterSpecification implements Comparator<ObservableOval> {
    @Override
    public int compare(ObservableOval firstOval, ObservableOval secondOval) {
        OvalParameters firstOvalParameters = firstOval.getParameters();
        OvalParameters secondOvalParameters = secondOval.getParameters();
        double firstOvalPerimeter = firstOvalParameters.getPerimeter();
        double secondOvalPerimeter = secondOvalParameters.getPerimeter();
        return firstOvalPerimeter > secondOvalPerimeter ? 1 :
                firstOvalPerimeter == secondOvalPerimeter ? 0 : -1;

    }
}
