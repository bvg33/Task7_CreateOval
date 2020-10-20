package com.epam.task7.logic.validator;

public class CoordinatesValidator implements Validator {
    @Override
    public boolean isValid(String line) {
            String[]coordinates=line.split(" ");
            double xOne=Double.parseDouble(coordinates[0]);
            double yOne=Double.parseDouble(coordinates[1]);
            double xTwo=Double.parseDouble(coordinates[2]);
            double yTwo=Double.parseDouble(coordinates[3]);
            return xOne<xTwo && yOne>yTwo;
    }
}
