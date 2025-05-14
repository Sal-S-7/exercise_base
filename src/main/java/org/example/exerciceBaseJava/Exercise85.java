package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise85 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nombreMystere = (int) Math.round(Math.random() * 100) + 1;
        int nbEssais = 0;

        while (true) {
            System.out.println("Veillez saisir un nombre : ");
            int nombreEntre = scanner.nextInt();
            nbEssais++;

            if (nombreEntre == nombreMystere){
                System.out.println("Bravo");
                System.out.println("Vous avez gagné après " + nbEssais + " tentatives");
                break;

            }   else if (nombreEntre > nombreMystere) {
                System.out.println("Petit");
            } else {
                System.out.println("Grand");
            }

        }
    }
}
