package com.epam.task7.data.repository;

import com.epam.task7.model.ObservableOval;
import com.epam.task7.data.specification.OvalSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObservableOvalRepository {
    private List<ObservableOval>ovals=new ArrayList<>();
    public ObservableOvalRepository(){
    }

    public ObservableOvalRepository(List<ObservableOval> ovals) {
        this.ovals = ovals;
    }

    public List<ObservableOval> getOvals() {
        return ovals;
    }
    public void addToList(ObservableOval...ovalsToAdd){
        for(ObservableOval oval:ovalsToAdd){
            ovals.add(oval);
        }
    }
    public void removeFromList(ObservableOval...ovalsToRemove){
        for(ObservableOval oval:ovalsToRemove){
            ovals.remove(oval);
        }
    }
    public List<ObservableOval> query(OvalSpecification specification){
        List<ObservableOval>listToReturn=new ArrayList<>();
        for(ObservableOval oval:ovals){
            if(specification.specified(oval)){
                listToReturn.add(oval);
            }
        }
        return listToReturn;
    }
    public List<ObservableOval> sort(Comparator<ObservableOval> comparator) {
        List<ObservableOval> listToReturn = new ArrayList<>(ovals);
        Collections.sort(listToReturn,comparator);
        return listToReturn;
    }

}
