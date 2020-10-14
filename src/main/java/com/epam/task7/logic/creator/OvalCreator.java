package com.epam.task7.logic.creator;

import com.epam.task7.data.DataReader;
import com.epam.task7.data.FileDataReader;
import com.epam.task7.exceptions.DataException;
import com.epam.task7.logic.parser.Parser;
import com.epam.task7.logic.validator.Validator;
import com.epam.task7.model.Oval;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OvalCreator implements Creator<Oval> {
    private Parser <Oval> parser;
    private Validator <String> validator;
    private DataReader reader;
    private static final Logger LOGGER=Logger.getLogger(OvalCreator.class);
    public OvalCreator(Parser parser, Validator validator, DataReader reader) {
        this.parser = parser;
        this.validator = validator;
        this.reader=reader;
    }

    @Override
    public List<Oval> create() throws DataException {
        List<String> lines=reader.readLines();
        List<Oval>ovals=new ArrayList<>();
        for(String line:lines){
            if(validator.isValid(line)){
                Oval oval=parser.parse(line);
                ovals.add(oval);
            }else {
                LOGGER.info("Invalid coordinates:"+ line);
            }
        }
        return ovals;
    }
}
