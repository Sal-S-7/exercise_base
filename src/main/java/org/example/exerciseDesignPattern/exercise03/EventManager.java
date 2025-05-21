package org.example.exerciseDesignPattern.exercise03;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void createEvent(String nameEvent){
        // Ici, je crée un event
        notifyObserver(nameEvent);
    }


    public void notifyObserver(String event){
        for (Observer observer: observers){
            observer.onNotify(event);
        }
    }
}


