package com.epam.task7.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class TestCoordinatesValidator {
    private final Validator validator=new CoordinatesValidator();
    @Test
    public void testIsValidShouldReturnTrueWhenLinesAreValid(){
        String actualStringOne="4 2 7 1";
        String actualStringTwo="-4 8 -2 4";
        String actualStringThree="-1 -2 0 -4";
        boolean actualOne= validator.isValid(actualStringOne);
        boolean actualTwo= validator.isValid(actualStringTwo);
        boolean actualThree= validator.isValid(actualStringThree);
        Assert.assertEquals(true,actualOne);
        Assert.assertEquals(true,actualTwo);
        Assert.assertEquals(true,actualThree);
    }
    @Test
    public void testIsValidShouldReturnFalseWhenLinesAreNotValid(){
        String actualStringOne="4 2 3 1";
        String actualStringTwo="-4 2 -2 4";
        String actualStringThree="-1 -7 0 -4";
        boolean actualOne= validator.isValid(actualStringOne);
        boolean actualTwo= validator.isValid(actualStringTwo);
        boolean actualThree= validator.isValid(actualStringThree);
        Assert.assertEquals(false,actualOne);
        Assert.assertEquals(false,actualTwo);
        Assert.assertEquals(false,actualThree);
    }
}
