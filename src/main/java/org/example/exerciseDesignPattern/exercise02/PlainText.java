package org.example.exerciseDesignPattern.exercise02;

// Texte brut
public class PlainText implements Text{
    @Override
    public String transform(String input) {
        return input;
    }
}
