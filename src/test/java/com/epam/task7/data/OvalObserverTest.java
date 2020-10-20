package com.epam.task7.data;

import com.epam.task7.data.observers.OvalObserver;
import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class OvalObserverTest {
    private final OvalObserver observer=OvalObserver.getInstance();
    @Test
    public void testNotifyShouldCalculateParametersWhenDataIsCorrect(){
        ObservableOval oval=new ObservableOval(new Point(4,2),new Point(7,1));
        observer.notify(oval);
        OvalParameters actualParameters= observer.getParameters(1);
        double actualArea=actualParameters.getArea();
        double actualPerimeter=actualParameters.getPerimeter();
        Assert.assertEquals(2.35,actualArea,0.1);
        Assert.assertEquals(7,actualPerimeter,0.1);
    }
}
