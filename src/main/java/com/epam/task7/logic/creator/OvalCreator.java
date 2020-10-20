package com.epam.task7.logic.creator;

import com.epam.task7.data.DataReader;
import com.epam.task7.exceptions.DataException;
import com.epam.task7.logic.parser.Parser;
import com.epam.task7.logic.validator.Validator;
import com.epam.task7.model.Oval;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OvalCreator implements Creator<Oval> {
    private Parser <Oval> parser;
    private Validator  lineValidator;
    private DataReader reader;
    private Validator coordinatesValidator;
    private static final Logger LOGGER=Logger.getLogger(OvalCreator.class);
    public OvalCreator(Parser parser, Validator lineValidator, DataReader reader,Validator coordinatesValidator) {
        this.parser = parser;
        this.lineValidator = lineValidator;
        this.reader=reader;
        this.coordinatesValidator=coordinatesValidator;
    }

    @Override
    public List<Oval> create() throws DataException {
        List<String> lines=reader.readLines();
        List<Oval>ovals=new ArrayList<>();
        for(String line:lines){
            if(lineValidator.isValid(line) && coordinatesValidator.isValid(line)){
                Oval oval=parser.parse(line);
                ovals.add(oval);
            }else {
                LOGGER.info("Invalid coordinates:"+ line);
            }
        }
        return ovals;
    }
}
