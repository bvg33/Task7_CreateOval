package com.epam.task7;

import com.epam.task7.data.DataReader;
import com.epam.task7.data.FileDataReader;
import com.epam.task7.exceptions.DataException;
import com.epam.task7.logic.calculator.OvalCalculator;
import com.epam.task7.logic.creator.Creator;
import com.epam.task7.logic.creator.OvalCreator;
import com.epam.task7.logic.parser.OvalParser;
import com.epam.task7.logic.parser.Parser;
import com.epam.task7.logic.validator.CoordinatesValidator;
import com.epam.task7.logic.validator.Validator;
import com.epam.task7.model.Oval;

import java.util.List;

public class Main {
    private static final String INPUT_FILENAME = "input.txt";
    public static void main(String[] args) {
        try {
            run();
        } catch (DataException e) {
            e.printStackTrace();
        }
    }

    private static void run() throws DataException {
        DataReader reader=new FileDataReader(INPUT_FILENAME);
        Parser parser=new OvalParser();
        Validator validator=new CoordinatesValidator();
        Creator<Oval> creator=new OvalCreator(parser,validator,reader);
        List<Oval> ovals=creator.create();
        OvalCalculator calculator=new OvalCalculator();
        for(Oval oval:ovals){
            System.out.println(oval);
        }
       // boolean res=calculator.isCrossAxisAtAGivenDistance(ovals.get(1),5);
       // System.out.println(res);
    }
}
