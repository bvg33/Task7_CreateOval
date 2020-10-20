package com.epam.task7.data.specification;

import com.epam.task7.model.ObservableOval;

public class OvalIdSpecification implements OvalSpecification {
    private int requiredId;

    public OvalIdSpecification(int requiredId) {
        this.requiredId = requiredId;
    }

    @Override
    public boolean specified(ObservableOval oval) {
        int currentId=oval.getId();
        return currentId==requiredId;
    }
}
