package org.example.exerciseDesignPattern.exercise02;

public class PrefixDecorator extends TextDecorator{

    private String prefix;

    public PrefixDecorator(Text text,String prefix) {
        super(text);
        this.prefix = prefix;
    }

    @Override
    public String transform(String input) {
        return prefix+" "+super.transform(input);
    }
}
