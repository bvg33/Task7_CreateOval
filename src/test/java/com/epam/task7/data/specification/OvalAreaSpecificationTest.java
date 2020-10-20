package com.epam.task7.data.specification;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class OvalAreaSpecificationTest {
    private final OvalSpecification specification=new OvalAreaSpecification(1,9);
    @Test
    public void testSpecifiedShouldReturnTrueWhenOvalIsSuitable(){
        ObservableOval oval=new ObservableOval(new Point(4,2),new Point(7,1));
        boolean actual=specification.specified(oval);
        Assert.assertEquals(true,actual);
    }
    @Test
    public void testSpecifiedShouldReturnFalseWhenOvalIsNotSuitable(){
        ObservableOval oval=new ObservableOval(new Point(1,1),new Point(15,15));
        boolean actual=specification.specified(oval);
        Assert.assertEquals(false,actual);
    }
}
