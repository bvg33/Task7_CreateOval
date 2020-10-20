package com.epam.task7.data.specification;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;

public class OvalAreaSpecification implements OvalSpecification {
    private double minArea;
    private double maxArea;

    public OvalAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(ObservableOval oval) {
        OvalParameters parameters=oval.getParameters();
        double area= parameters.getArea();
        return area>=minArea && area<=maxArea;
    }
}
