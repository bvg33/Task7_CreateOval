package com.epam.task7.data.observers;

import com.epam.task7.logic.calculator.OvalCalculator;
import com.epam.task7.model.ObservableOval;
import com.epam.task7.model.OvalParameters;

import java.util.HashMap;
import java.util.Map;

public class OvalObserver implements Observer<ObservableOval> {
    private Map<Integer, OvalParameters> parametersMap = new HashMap<>();
    private OvalCalculator calculator;
    private static final OvalObserver INSTANCE = new OvalObserver();

    public static OvalObserver getInstance() {
        return INSTANCE;
    }

    private OvalObserver() {
        calculator = new OvalCalculator();
    }

    @Override
    public void notify(ObservableOval observableOval) {
        double area = calculator.calculateArea(observableOval);
        double perimeter = calculator.calculatePerimeter(observableOval);
        OvalParameters parameters = new OvalParameters(area, perimeter);
        parametersMap.put(observableOval.getId(), parameters);
    }

    public OvalParameters getParameters(int id) {
        return parametersMap.get(id);
    }
}
