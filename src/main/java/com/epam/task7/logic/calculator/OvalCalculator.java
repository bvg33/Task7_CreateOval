package com.epam.task7.logic.calculator;

import com.epam.task7.model.Oval;
import com.epam.task7.model.OvalParameters;
import com.epam.task7.model.Point;

public class OvalCalculator {
    private static final double PI=3.1415;
    private double calculateMajorAxis(Point pointOne,Point pointTwo){
        double xOne=pointOne.getX();
        double xTwo=pointTwo.getX();
        return Math.abs(xOne-xTwo);
    }
    private double calculateMinorAxis(Point pointOne,Point pointTwo){
        double yOne=pointOne.getY();
        double yTwo=pointTwo.getY();
        return Math.abs(yOne-yTwo);
    }
    private OvalParameters calculateOvalParameters(Oval oval) {
        Point pointOne=oval.getPointOne();
        Point pointTwo=oval.getPointTwo();
        double minorAxis=calculateMinorAxis(pointOne,pointTwo);
        double majorAxis= calculateMajorAxis(pointOne,pointTwo);
        return new OvalParameters(minorAxis,majorAxis,pointOne,pointTwo);
    }
    public double calculateArea(Oval oval){
        OvalParameters parameters=calculateOvalParameters(oval);
        double minorAxis= parameters.getMinorAxis();
        double majorAxis= parameters.getMajorAxis();
        return (PI* minorAxis*majorAxis)/4;
    }
    public double calculatePerimeter(Oval oval){
        OvalParameters parameters=calculateOvalParameters(oval);
        double minorAxis= parameters.getMinorAxis();
        double majorAxis= parameters.getMajorAxis();
        double squareMinorAxis=Math.pow(minorAxis,2);
        double squareMajorAxis= Math.pow(majorAxis,2);
        return 2*PI*Math.sqrt((squareMajorAxis+squareMinorAxis)/8);
    }
    public boolean isCircle(Oval oval){
        OvalParameters parameters=calculateOvalParameters(oval);
        double minorAxis= parameters.getMinorAxis();
        double majorAxis= parameters.getMajorAxis();
        return minorAxis==majorAxis;
    }
    public boolean areDotsFormOvals(Point pointOne, Point pointTwo){
        double xOne=pointOne.getX();
        double yOne= pointOne.getY();
        double xTwo= pointTwo.getX();
        double yTwo= pointTwo.getY();
        return xOne!=xTwo && yOne!=yTwo;
    }
    public boolean isCrossAxisAtAGivenDistance(Oval oval,double distance){
        OvalParameters parameters=calculateOvalParameters(oval);
        double xOne= parameters.getPointOneX();
        double yOne= parameters.getPointOneY();
        double xTwo= parameters.getPointTwoX();
        double yTwo= parameters.getPointTwoY();
        boolean result=false;
        if(-1*xOne>=distance && yOne>0 && xTwo>0 && -1*yTwo>=distance){
            return false;
        }
        if(-1*xOne>=distance && yOne>0 && xTwo>0 && yTwo>0){
            result=true;
        }else if(xOne>0 && yOne>0 && xTwo>0 && -1*yTwo>=distance){
            result=true;
        }
        return result;
    }
}
