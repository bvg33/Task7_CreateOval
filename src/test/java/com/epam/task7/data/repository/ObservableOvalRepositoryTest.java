package com.epam.task7.data.repository;

import com.epam.task7.data.sort.SorterByIdSpecification;
import com.epam.task7.data.specification.OvalIdSpecification;
import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ObservableOvalRepositoryTest {
    private final ObservableOvalRepository repository=new ObservableOvalRepository();
    @Test
    public void testAddToListShouldAddWhenOvalIsCorrect(){
        ObservableOval oval=new ObservableOval(new Point(2,3),new Point(3,4));
        repository.addToList(oval);
        List<ObservableOval>actual= repository.getOvals();
        List<ObservableOval>expected=new ArrayList<ObservableOval>();
        expected.add(oval);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testRemoveFromListShouldRemoveWhenOvalIsInCorrect(){
        ObservableOval oval=new ObservableOval(new Point(2,3),new Point(3,4));
        repository.addToList(oval);
        repository.removeFromList(oval);
        List<ObservableOval>actual= repository.getOvals();
        List<ObservableOval>expected=new ArrayList<ObservableOval>();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testRemoveFromListShouldNotRemoveWhenOvalIsNotInCorrect(){
        ObservableOval oval=new ObservableOval(new Point(2,3),new Point(3,4));
        ObservableOval ovalTwo=new ObservableOval(new Point(5,6),new Point(7,8));
        repository.addToList(oval);
        repository.removeFromList(ovalTwo);
        List<ObservableOval>actual= repository.getOvals();
        List<ObservableOval>expected=new ArrayList<ObservableOval>();
        expected.add(oval);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testQueryShouldReturnSuitableOvals(){
        OvalIdSpecification specification= Mockito.mock(OvalIdSpecification.class);
        when(specification.specified(Matchers.<ObservableOval>anyObject())).thenReturn(true);
        ObservableOval oval=new ObservableOval(new Point(2,3),new Point(3,4));
        ObservableOval ovalTwo=new ObservableOval(new Point(5,6),new Point(7,8));
        repository.addToList(oval,ovalTwo);
        List<ObservableOval>expected=repository.getOvals();
        List<ObservableOval>actual=repository.query(specification);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testSortShouldSortWhenSpecificationIsCorrect(){
        SorterByIdSpecification specification= Mockito.mock(SorterByIdSpecification.class);
        when(specification.compare(Matchers.<ObservableOval>anyObject(),Matchers.<ObservableOval>anyObject())).thenReturn(1);
        ObservableOval oval=new ObservableOval(new Point(2,3),new Point(3,4));
        ObservableOval ovalTwo=new ObservableOval(new Point(5,6),new Point(7,8));
        repository.addToList(oval,ovalTwo);
        List<ObservableOval>expected=repository.getOvals();
        List<ObservableOval>actual=repository.sort(specification);
        Assert.assertEquals(expected,actual);
    }

}
