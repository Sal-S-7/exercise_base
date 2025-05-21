package org.example.exerciseDesignPattern.tpPereNoel.factory;

public class Plush implements Toys{
    @Override
    public String getDescription() {
        return "peluche";
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
