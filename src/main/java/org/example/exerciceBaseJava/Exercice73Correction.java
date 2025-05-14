package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercice73Correction {
    /*
    1.Créer une variable mois de type entier
    2.Affecter une valeur à la variable mois
    3.Afficher le nombre de jours du mois
    4.Si le nombre est inférieur à 1 et supérieur à 12, afficher un message d'erreur
     */
    public static void main(String[] args) {
        // Scanner pour permettre la lecture de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);


        System.out.println("Sasir un n° de mois : ");
        int mois = scanner.nextInt();

        switch (mois){
            case 2 -> System.out.println("28 ou 29 jours ");
            case 4, 6, 9, 11 -> System.out.println("30 jours");
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("31 jours");
            default -> System.out.println("Sasie invalide !!!");
        }

    }
}