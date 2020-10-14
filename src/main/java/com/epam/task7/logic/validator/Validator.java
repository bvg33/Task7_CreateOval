package com.epam.task7.logic.validator;

public interface Validator<T> {
    boolean isValid(T validatedParameter);
}
