package com.epam.task7.logic.creator;

import com.epam.task7.data.FileDataReader;
import com.epam.task7.exceptions.DataException;
import com.epam.task7.logic.parser.OvalParser;
import com.epam.task7.logic.validator.CoordinatesValidator;
import com.epam.task7.logic.validator.LinesValidator;
import com.epam.task7.model.Oval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class TestOvalCreator {
    @Test
    public void testCreateShouldReturnOvalWhenDataIsCorrect() throws DataException {
        FileDataReader fileDataReader=Mockito.mock(FileDataReader.class);
        List<String>listToReturn=new ArrayList<>();
        listToReturn.add("4 2 7 1");
        when(fileDataReader.readLines()).thenReturn(listToReturn);
        LinesValidator linesValidator = Mockito.mock(LinesValidator.class);
        when(linesValidator.isValid(anyString())).thenReturn(true);
        CoordinatesValidator coordinatesValidator = Mockito.mock(CoordinatesValidator.class);
        when(coordinatesValidator.isValid(anyString())).thenReturn(true);
        OvalParser parser=Mockito.mock(OvalParser.class);
        Oval oval=new Oval(new Point(4,2),new Point(7,1));
        when(parser.parse(anyString())).thenReturn(oval);
        OvalCreator creator=new OvalCreator(parser, linesValidator,fileDataReader,coordinatesValidator);
        List<Oval> actual=creator.create();
        List<Oval> expected=new ArrayList<>();
        expected.add(oval);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateShouldReturnEmptyListWhenDataIsNotCorrect() throws DataException {
        FileDataReader fileDataReader=Mockito.mock(FileDataReader.class);
        List<String>listToReturn=new ArrayList<>();
        listToReturn.add("4 2 7 1");
        when(fileDataReader.readLines()).thenReturn(listToReturn);
        LinesValidator validator= Mockito.mock(LinesValidator.class);
        when(validator.isValid(anyString())).thenReturn(false);
        CoordinatesValidator coordinatesValidator = Mockito.mock(CoordinatesValidator.class);
        when(coordinatesValidator.isValid(anyString())).thenReturn(true);
        OvalParser parser=new OvalParser();
        OvalCreator creator=new OvalCreator(parser,validator,fileDataReader,coordinatesValidator);
        List<Oval> actual=creator.create();
        List<Oval> expected=new ArrayList<>();
        Assert.assertEquals(expected,actual);
    }
}
