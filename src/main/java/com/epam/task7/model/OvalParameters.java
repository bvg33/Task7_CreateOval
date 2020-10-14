package com.epam.task7.model;

public class OvalParameters {
    private double minorAxis;
    private double majorAxis;
    private double pointOneX;
    private double pointOneY;
    private double pointTwoX;
    private double pointTwoY;
    public OvalParameters(double minorAxis, double majorAxis,Point pointOne,Point pointTwo) {
        this.minorAxis = minorAxis;
        this.majorAxis = majorAxis;
        pointOneX=pointOne.getX();
        pointOneY=pointOne.getY();
        pointTwoX=pointTwo.getX();
        pointTwoY=pointTwo.getY();
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public double getMajorAxis() {
        return majorAxis;
    }

    public double getPointOneX() {
        return pointOneX;
    }

    public double getPointOneY() {
        return pointOneY;
    }

    public double getPointTwoX() {
        return pointTwoX;
    }

    public double getPointTwoY() {
        return pointTwoY;
    }
}
