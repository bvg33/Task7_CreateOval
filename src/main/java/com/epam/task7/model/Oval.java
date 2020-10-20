package com.epam.task7.model;

import java.util.Objects;

public class Oval {
    private Point pointOne;
    private Point pointTwo;

    public Oval(Point pointOne, Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Oval oval = (Oval) o;
        return Objects.equals(pointOne, oval.pointOne) &&
                Objects.equals(pointTwo, oval.pointTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointOne, pointTwo);
    }

    @Override
    public String toString() {
        return "Oval{" +
                "pointOne=" + pointOne +
                ", pointTwo=" + pointTwo +
                '}';
    }
}
