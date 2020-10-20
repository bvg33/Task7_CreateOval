package com.epam.task7.logic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinesValidator implements Validator {
    private static final String REGEX="(^(-?\\d+(\\.\\d+)?\\s){3})(-?\\d+(\\.\\d+)?)$";
    public boolean isValid(String line) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        String suitableString = "";
        return matcher.find();
    }

}
