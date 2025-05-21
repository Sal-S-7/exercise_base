package org.example.exerciseDesignPattern.tpPereNoel.decorator;

import org.example.exerciseDesignPattern.tpPereNoel.factory.Toys;

public class AccessoriesDecorator extends ToysDecorator {
    public AccessoriesDecorator(Toys decoratedToy) {
        super(decoratedToy);
    }

    @Override
    public String getDescription() {
        return super.decoratedToy.getDescription() + " avec papier cadeau";
    }

    @Override
    public double cost() {
        return super.decoratedToy.cost() + 5.0;
    }

    @Override
    public String ready() {
        return " est prêt";
    }
}

