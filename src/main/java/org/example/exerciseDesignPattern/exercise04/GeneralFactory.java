package org.example.exerciseDesignPattern.exercise04;

import java.util.HashMap;
import java.util.Map;

public class GeneralFactory {

    private Map<String,AnimalFactory> factoryMap= new HashMap<>();

    public void saveFactory(String typeFactory, AnimalFactory factory){
        factoryMap.put(typeFactory, factory);
    }


    public Animal produceAnimal(String typeAnimal){
        AnimalFactory factory = factoryMap.get(typeAnimal);
        Animal animal = factory.createAnimal();
        return animal;
    }
}
