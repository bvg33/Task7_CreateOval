package com.epam.task7.data.specification;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;

public class OvalPerimeterSpecification implements OvalSpecification {
    private double minPerimeter;
    private double maxPerimeter;

    public OvalPerimeterSpecification(double minArea, double maxArea) {
        this.minPerimeter = minArea;
        this.maxPerimeter = maxArea;
    }

    @Override
    public boolean specified(ObservableOval oval) {
        OvalParameters parameters=oval.getParameters();
        double perimeter= parameters.getPerimeter();
        return perimeter>= minPerimeter && perimeter<= maxPerimeter;
    }
}
