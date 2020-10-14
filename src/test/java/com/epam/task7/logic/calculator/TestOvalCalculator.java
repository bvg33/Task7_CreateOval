package com.epam.task7.logic.calculator;

import com.epam.task7.model.Oval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestOvalCalculator {
    private final OvalCalculator calculator=new OvalCalculator();
    @Test
    public void testCalculateAreaShouldCalculateWhenOvalIsCorrect(){
        Oval oval=new Oval(new Point(4,2),new Point(7,1));
        double actual=calculator.calculateArea(oval);
        Assert.assertEquals(2.35,actual,0.1);
    }
    @Test
    public void testCalculatePerimeterShouldCalculateWhenOvalIsCorrect(){
        Oval oval=new Oval(new Point(4,2),new Point(7,1));
        double actual=calculator.calculatePerimeter(oval);
        Assert.assertEquals(7,actual,0.1);
    }
    @Test
    public void testIsCircleShouldReturnTrueWhenOvalIsCircle(){
        Oval oval=new Oval(new Point(4,2),new Point(7,-1));
        boolean actual=calculator.isCircle(oval);
        Assert.assertEquals(true,actual);
    }
    @Test
    public void testIsCircleShouldReturnFalseWhenOvalIsNotCircle(){
        Oval oval=new Oval(new Point(4,2),new Point(9,-1));
        boolean actual=calculator.isCircle(oval);
        Assert.assertEquals(false,actual);
    }
    @Test
    public void testAreDotsFormOvalsShouldReturnTrueWhenForm(){
        Point pointOne=new Point(3,4);
        Point pointTwo=new Point(5,6);
        boolean actual=calculator.areDotsFormOvals(pointOne,pointTwo);
        Assert.assertEquals(true,actual);
    }
    @Test
    public void testAreDotsFormOvalsShouldReturnFalseWhenDoNotForm(){
        Point pointOne=new Point(3,4);
        Point pointTwo=new Point(3,6);
        boolean actual=calculator.areDotsFormOvals(pointOne,pointTwo);
        Assert.assertEquals(false,actual);
    }
    @Test
    public void testIsCrossAxisAtAGivenDistanceShouldReturnTrueWhenCross(){
        Oval oval=new Oval(new Point(-4,2),new Point(7,1));
        boolean res=calculator.isCrossAxisAtAGivenDistance(oval,3);
        Assert.assertEquals(true,res);
    }
    @Test
    public void testIsCrossAxisAtAGivenDistanceShouldReturnFalseWhenDoNotCross(){
        Oval oval=new Oval(new Point(2,2),new Point(7,1));
        boolean res=calculator.isCrossAxisAtAGivenDistance(oval,3);
        Assert.assertEquals(false,res);
    }
}
