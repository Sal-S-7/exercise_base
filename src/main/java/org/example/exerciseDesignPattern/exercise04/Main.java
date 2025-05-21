package org.example.exerciseDesignPattern.exercise04;

public class Main {
    public static void main(String[] args) {

//        AnimalFactory catFactory = new CatFactory();
//        Animal cat = catFactory.createAnimal();
//        cat.noise();
//
//        AnimalFactory dogFactory = new DogFactory();
//        Animal dog = dogFactory.createAnimal();
//        dog.noise();
//

        GeneralFactory generalFactory = new GeneralFactory();

        generalFactory.saveFactory("Dog", new DogFactory());
        generalFactory.saveFactory("Cat", new CatFactory());

        Animal cat = generalFactory.produceAnimal("Chat");
        cat.noise();
        Animal dog = generalFactory.produceAnimal("Dog");
        dog.noise();

    }
}
