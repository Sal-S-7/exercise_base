package org.example.exerciceBaseJava;

import java.util.Arrays;
import java.util.Scanner;

public class Exercice56Correction {
    /*
    1.Saisir une chaine et la stocker dans une variable
    2.Effectuer les traitements suivants :
    1.Afficher la chaîne en minuscule
    2.Afficher la chaîne en majuscule
    3.Bonus
    1.Convertir la chaîne en tableau puis afficher les caractères séparer d'une virgule
    2.Afficher la première lettre de chaque mot en majuscule
     */
    public static void main(String[] args) {
        // Scanner pour permettre la lecture de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        String chaineInitiale;
        String chaineMinuscule;
        String chaineMajuscule;
        String[] motsChaine;

        System.out.println("Saisir une chaine de caracteres :");
        chaineInitiale = scanner.nextLine();

        chaineMinuscule = chaineInitiale.toLowerCase();
        chaineMajuscule = chaineInitiale.toUpperCase();

        System.out.println(chaineMinuscule);
        System.out.println(chaineMajuscule);

        motsChaine = chaineInitiale.split("");
        System.out.println(Arrays.toString(motsChaine));

        String[] tabMots = chaineInitiale.split(" ");
        System.out.println(Arrays.toString(tabMots));

        for (String mot : tabMots){
            System.out.print(mot.substring(0,1).toUpperCase()+mot.substring(1).toLowerCase()+" ");
        }



    }
}
