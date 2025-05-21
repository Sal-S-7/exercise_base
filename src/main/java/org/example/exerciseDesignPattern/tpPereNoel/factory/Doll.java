package org.example.exerciseDesignPattern.tpPereNoel.factory;

public class Doll implements Toys{
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
