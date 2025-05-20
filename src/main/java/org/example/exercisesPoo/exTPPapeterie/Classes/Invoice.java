package org.example.exercisesPoo.exTPPapeterie.Classes;

import java.util.ArrayList;

public class Invoice {
    private static int numberCount = 1;

    private String numberID;
    private String client;
    private String date;
    private ArrayList<Line> lines;

    public Invoice(String client, String date) {
        this.numberID = "N°" + numberCount++;
        this.client = client;
        this.date = date;
        this.lines = new ArrayList<>();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Line line : lines) {
            total += line.getTotalPrice();
        }
        return total;
    }

    public String toString() {
        System.out.println("Facture " + numberID + " Client : " + client + " Date : " + date);
        for (Line line : lines) {
            line.showLine();
        }
        System.out.println("TOTAL : " + getTotalPrice() + "€");
        return null;
    }
}
