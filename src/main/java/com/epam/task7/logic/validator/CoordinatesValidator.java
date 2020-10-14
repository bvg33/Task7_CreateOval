package com.epam.task7.logic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesValidator implements Validator<String> {
    private static final String REGEX="(^(-?\\d+(\\.\\d+)?\\s){3})(-?\\d+(\\.\\d+)?)$";
    public boolean isValid(String line){
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher= pattern.matcher(line);
        String suitableString="";
        if (matcher.find()) {
           suitableString = matcher.group();
           return isValidCoordinates(suitableString);
        }else {
            return false;
        }
    }

    private boolean isValidCoordinates(String suitableString) {
        String[]coordinates=suitableString.split(" ");
        double xOne=Double.parseDouble(coordinates[0]);
        double yOne=Double.parseDouble(coordinates[1]);
        double xTwo=Double.parseDouble(coordinates[2]);
        double yTwo=Double.parseDouble(coordinates[3]);
        return xOne<xTwo && yOne>yTwo;
    }
}
