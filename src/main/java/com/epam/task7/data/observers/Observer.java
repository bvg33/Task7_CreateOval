package com.epam.task7.data.observers;

public interface Observer <T>{
    void notify(T observable);
}
