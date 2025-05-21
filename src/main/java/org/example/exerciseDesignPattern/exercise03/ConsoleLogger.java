package org.example.exerciseDesignPattern.exercise03;

import java.util.Date;

public class ConsoleLogger implements Observer {

    @Override
    public void onNotify(String event) {
        System.out.println("Enregistrement dans un fichier de log de : "+event);

    }
}
