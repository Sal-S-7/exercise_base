package org.example.exerciseDesignPattern.tpPereNoel;


import org.example.exerciseDesignPattern.tpPereNoel.decorator.AccessoriesDecorator;
import org.example.exerciseDesignPattern.tpPereNoel.decorator.CustomizationDecorator;
import org.example.exerciseDesignPattern.tpPereNoel.factory.*;
import org.example.exerciseDesignPattern.tpPereNoel.observer.ElfObserver;
import org.example.exerciseDesignPattern.tpPereNoel.observer.ToyNotif;

public class Main {
    public static void main(String[] args) {

        ToysFactory dollFactory = new DollFactory();
        Toys doll = dollFactory.createToy();


        doll = new AccessoriesDecorator(doll);

        System.out.println("Le jouet " + doll.getDescription() + " de coût : " + doll.cost() + doll.ready()) ;

        Toys plush = new Plush();


        plush = new CustomizationDecorator(plush);
        System.out.println("Le jouet " + plush.getDescription() + " de coût : " + plush.cost()+ doll.ready());




        ToyNotif toyNotif = new ToyNotif();
        Elf elf1 = new Elf("Toto");
        Elf elf2 = new Elf("Toto Jr.");

        toyNotif.addObserver((ElfObserver) elf1);
        toyNotif.addObserver((ElfObserver) elf2);
        toyNotif.produceToy(doll);
        toyNotif.produceToy(plush);
    }
}
