package org.example.exerciseDesignPattern.tpPereNoel.factory;

public class PlushFactory extends ToysFactory {
        public Toys createToy() {
            return new Plush();
        }

}
