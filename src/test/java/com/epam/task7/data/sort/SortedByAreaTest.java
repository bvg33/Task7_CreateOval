package com.epam.task7.data.sort;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class SortedByAreaTest {
    private final SorterByAreaSpecification sorter=new SorterByAreaSpecification();
    @Test
    public void testCompareShouldReturnOneWhenObjectOneBiggerThanObjectTwo(){
        ObservableOval ovalOne=new ObservableOval(new Point(4,2),new Point(7,1));
        ObservableOval ovalTwo=new ObservableOval(new Point(1,1),new Point(14,14));
        int actual=sorter.compare(ovalTwo,ovalOne);
        Assert.assertEquals(1,actual);
    }
    @Test
    public void testCompareShouldReturnZeroWhenObjectOneBiggerThanObjectTwo(){
        ObservableOval ovalOne=new ObservableOval(new Point(4,2),new Point(7,1));
        ObservableOval ovalTwo=new ObservableOval(new Point(4,2),new Point(7,1));
        int actual=sorter.compare(ovalTwo,ovalOne);
        Assert.assertEquals(0,actual);
    }
    @Test
    public void testCompareShouldReturnMinusOneWhenObjectOneBiggerThanObjectTwo(){
        ObservableOval ovalOne=new ObservableOval(new Point(4,2),new Point(7,1));
        ObservableOval ovalTwo=new ObservableOval(new Point(1,1),new Point(14,14));
        int actual=sorter.compare(ovalOne,ovalTwo);
        Assert.assertEquals(-1,actual);
    }
}
