package org.example.exerciseDesignPattern.tpPereNoel.decorator;

import org.example.exerciseDesignPattern.tpPereNoel.factory.Toys;

public class CustomizationDecorator extends ToysDecorator {
    public CustomizationDecorator(Toys decoratedToy) {
        super(decoratedToy);
    }

    @Override
    public String getDescription() {
        return decoratedToy.getDescription() + " personnalisé";
    }

    @Override
    public double cost() {
        return decoratedToy.cost() + 10.0;
    }

    @Override
    public String ready() {
        return " est prêt";
    }
}
