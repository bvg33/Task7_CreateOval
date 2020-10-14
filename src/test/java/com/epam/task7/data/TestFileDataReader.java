package com.epam.task7.data;

import com.epam.task7.exceptions.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFileDataReader {
    private static final String FILENAME="src/test/resources/correctInput.txt";
    @Test
    public void testReadLinesShouldReadLinesWhenFileIsExist() throws DataException {
        DataReader reader=new FileDataReader(FILENAME);
        List<String>actual= reader.readLines();
        List<String>expected=new ArrayList<>();
        expected.add("1 2 3 4");
        expected.add("1z 2 3");
        expected.add("-1 22 3 4");
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowExceptionWhenFileIsNotExist() throws DataException {
        DataReader reader=new FileDataReader("src/test/resources/IncorrectInput.txt");
        reader.readLines();
    }
}
