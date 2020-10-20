package com.epam.task7.model;

import com.epam.task7.data.observers.Observer;
import com.epam.task7.data.observers.OvalObserver;

import java.util.ArrayList;
import java.util.List;

public class ObservableOval extends Oval implements Observable {
    private static int idCounter=1;
    private int id;
    private List<Observer<ObservableOval>>observers=new ArrayList<>();
    public ObservableOval(Point pointOne, Point pointTwo) {
        super(pointOne, pointTwo);
        OvalObserver observer=OvalObserver.getInstance();
        observers.add(observer);
        id=idCounter++;
        notifyAllObservers();
    }

    @Override
    public void addObserver(Observer ovalObserver) {
        observers.add(ovalObserver);
    }

    public int getId() {
        return id;
    }

    @Override
    public void setPointOne(Point pointOne) {
        super.setPointOne(pointOne);
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer <ObservableOval> observer:observers) {
            observer.notify(this);
        }
    }

    @Override
    public void setPointTwo(Point pointTwo) {
        super.setPointTwo(pointTwo);
        notifyAllObservers();
    }
    public OvalParameters getParameters(){
        OvalObserver observer=OvalObserver.getInstance();
        return observer.getParameters(id);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ObservableOval{");
        String superToString=super.toString();
        sb.append(superToString);
        sb.append("id=").append(id);
        sb.append("parameters=").append(getParameters());
        sb.append('}');
        return sb.toString();
    }
}
