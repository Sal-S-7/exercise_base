package org.example.exerciseDesignPattern.exercise03;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void notifyObserver(String message){
        for (Observer observer:observers){
            observer.update(message);
        }

    public void clubName(String message){
            for (Observer observer:observers){
                observer.update(message);
            }
        }

    }
}

