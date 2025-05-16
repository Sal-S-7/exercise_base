package org.example.exercisesPoo.exTPPapeterie.Classes;

public class Weight extends Article {
    private String name;
    private double price;
    private int weight;

        public Weight(String reference, String name, double price, int weight) {
        super(reference);
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }


    public String toString() {
        return super.toString() + " - " + name + " - " + price + "€ - Grammage : " + weight + "g";
    }
}

