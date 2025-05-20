package org.example.exercisesPoo.exTPPapeterie;
import org.example.exercisesPoo.exTPPapeterie.Classes.*;

public class Main {
    public static void main(String[] args) {

        Pen pen1 = new Pen("S01", "Stylo Vert", 1.5, "Vert");
        Weight weight1 = new Weight("R01", "Ramette A4", 4.0, 80);
        Batch batch1 = new Batch("L01", pen1, 50, 0.5);
        Invoice invoice1 = new Invoice("Toto","12/05/25");

        System.out.println(pen1);
        System.out.println(weight1);
        System.out.println(invoice1);


                    // NON FINI
    }
}
