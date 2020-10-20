package com.epam.task7.model;

import java.util.Objects;

public class OvalParameters {

    private double area;
    private double perimeter;

    public OvalParameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "OvalParameters{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OvalParameters that = (OvalParameters) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter);
    }
}
