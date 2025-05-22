package org.example.exerciseDesignPattern.tpPereNoel.factory;

import java.util.HashMap;
import java.util.Map;

public class GeneralFactory {

    private Map<String,ToysFactory> factoryMap = new HashMap<>();


    // Enregistrer une nouvelle factory
    public void saveFactory(String typeFactory,ToysFactory factory){
        factoryMap.put(typeFactory,factory);
    }

   // utilisation d'un factory
    public Toys produceToys(String typeToys){
        ToysFactory factory = factoryMap.get(typeToys);

        Toys toy = factory.createToy();

        return toy;
    }
}
