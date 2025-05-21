package org.example.exerciseDesignPattern.tpPereNoel.observer;

import org.example.exerciseDesignPattern.tpPereNoel.factory.Toys;
import java.util.ArrayList;
import java.util.List;

public class ToyNotif {
    private List<ElfObserver> observers = new ArrayList<>();

    public void addObserver(ElfObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ElfObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (ElfObserver observer : observers) {
            observer.update(message);
        }
    }

    public void produceToy(Toys toy) {

        System.out.println("Production du jouet " + toy.getDescription());
        notifyObservers("Le jouet " + toy.getDescription() + " a été terminé.");
    }
}

