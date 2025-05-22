package org.example.exerciseDesignPattern.tpPereNoel.factory;

import org.example.exerciseDesignPattern.tpPereNoel.observer.ElfObserver;

import java.util.ArrayList;
import java.util.List;

public class Doll implements Toys {

    @Override
    public String getDescription() {
        return "poupée";
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String ready() {
        return " est prêt";
    }

}