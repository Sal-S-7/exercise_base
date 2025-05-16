package org.example.exercisesPoo.exTPPapeterie.Classes;

public class Pen extends Article {
    private String name;
    private double price;
    private String color;

    public Pen(String reference, String name, double price, String color) {
        super(reference);
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + name + " - " + price + "€ - Couleur : " + color;
    }
}

