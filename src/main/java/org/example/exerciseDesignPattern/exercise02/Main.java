package org.example.exerciseDesignPattern.exercise02;

public class Main {

    public static void main(String[] args) {
        Text text = new PlainText();

        // ajout d'un prefix
        text = new PrefixDecorator(text,">> - ");
        System.out.println(text.transform("Hello World !!!!"));

        // majuscule
        text = new UpperCaseDecorator(text);
        System.out.println(text);
        System.out.println(text.transform("Bonjour tous le monde !!!"));

        text = new PrefixDecorator(text," -> ");
        System.out.println(text.transform("Done ?"));
    }
}

