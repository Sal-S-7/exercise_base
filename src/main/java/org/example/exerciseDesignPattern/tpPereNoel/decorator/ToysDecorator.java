package org.example.exerciseDesignPattern.tpPereNoel.decorator;

import org.example.exerciseDesignPattern.tpPereNoel.factory.Toys;

public abstract class ToysDecorator implements Toys {
    protected Toys decoratedToy;

    public ToysDecorator(Toys decoratedToy) {
        this.decoratedToy = decoratedToy;
    }

    @Override
    public String getDescription() {
        return decoratedToy.getDescription();
    }

    @Override
    public double cost() {
        return decoratedToy.cost();
    }
}

