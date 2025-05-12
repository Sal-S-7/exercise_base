package org.example;

import java.util.Scanner;

public class Exercise56 {
    public static void main(String[] args) {
//        Exercice : Mise en forme de chaînes
//        1. Saisir une chaine et la stocker dans une variable
//        2. Effectuer les traitements suivants :
//        1. Afficher la chaîne en minuscule
//        2. Afficher la chaîne en majuscule
//        3. Bonus
//        1. Convertir la chaîne en tableau puis afficher les caractères séparer d'une virgule
//        2. Afficher la première lettre de chaque mot en majuscule

//        Saisir une chaîne : CoMMenT çA vA ?
//                En minuscule : comment ça va ?
//                En majuscule : COMMENT ÇA VA ?
//                En tableau : c,o,m,m,e,n,t, ,ç,a, ,v,a, ,?
//        Premiere lettre en majuscule : Comment Ça Va ?

        String text;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un text : ");
        text = scanner.nextLine();

        System.out.println("Minuscule : " + text.toLowerCase());

        System.out.println("Majuscule : " + text.toUpperCase());

    }
}
