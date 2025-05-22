package org.example.exerciseDesignPattern.tpPereNoel.observer;

public class Elf implements ElfObserver {
    private String name;

    public Elf(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " a reçu la notification: " + message);
    }
}

