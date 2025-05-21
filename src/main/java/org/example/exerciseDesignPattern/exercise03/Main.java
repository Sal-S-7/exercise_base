package org.example.exerciseDesignPattern.exercise03;

public class Main {
    public static void main(String[] args) {
        EventManager event = new EventManager();

        Observer user1 = new MyObserver("Toto");

        event.addObserver(user1);

        event.notifyObserver("'Votre demande à été acceptée'");



    }
}


//Objectif :
//Utilisez le pattern Observer pour créer un système de notification d'événements.
//        1. Implémentez une classe `EventManager` comme sujet,
//        permettant d'ajouter et de notifier des observateurs.
//        2. Implémentez plusieurs observateurs, chacun ayant une
//        réaction spécifique à une notification.
//        3. Testez en simulant des événements dans une classe principale.
