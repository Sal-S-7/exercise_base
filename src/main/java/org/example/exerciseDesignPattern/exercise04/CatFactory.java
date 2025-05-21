package org.example.exerciseDesignPattern.exercise04;

public class CatFactory extends AnimalFactory{

    public Animal createAnimal(){
        return new Cat();
    }
}
