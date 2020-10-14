package com.epam.task7.logic.parser;

import com.epam.task7.model.Oval;
import com.epam.task7.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class TestOvalParser {
    private final Parser<Oval>parser=new OvalParser();
    @Test
    public void testParseShouldParseWhenDataIsCorrect(){
        String actualString="4 2 7 1";
        Oval actual=parser.parse(actualString);
        Oval expected=new Oval(new Point(4,2),new Point(7,1));
        Assert.assertEquals(expected,actual);
    }
}
