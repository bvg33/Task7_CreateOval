package com.epam.task7.exceptions;

public class DataException extends Exception {
    public DataException(String message,Exception e){
        super(message,e);
    }
}
