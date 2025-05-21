package org.example.exerciseDesignPattern.exercise04;

public class DogFactory extends AnimalFactory {

    public Animal createAnimal(){
        return new Dog();
    }
}

