package org.example.exerciseDesignPattern.exercise03;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        eventManager.addObserver(new ConsoleLogger());
        eventManager.addObserver(new FileLogger());
        
        eventManager.notifyObserver("Event 001");
        eventManager.notifyObserver("Event 002");


    }
}


