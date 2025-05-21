package org.example.exerciseDesignPattern.tpPereNoel.factory;

public class DollFactory extends ToysFactory {
    public Toys createToy() {
        return new Doll();
    }
}