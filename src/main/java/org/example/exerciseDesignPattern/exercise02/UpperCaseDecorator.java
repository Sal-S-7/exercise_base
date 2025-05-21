package org.example.exerciseDesignPattern.exercise02;

public class UpperCaseDecorator extends TextDecorator{
    public UpperCaseDecorator(Text text) {
        super(text);
    }

    @Override
    public String transform(String input) {
        return super.transform(input).toUpperCase();
    }
}
