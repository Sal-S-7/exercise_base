package org.example;

import java.util.Scanner;

public class Exercise73 {
//    1. Créer une variable mois de type entier
//    2. Affecter une valeur à la variable mois
//    3. Afficher le nombre de jours du mois
//    4. Si le nombre est inférieur à 1 et supérieur à 12, afficher un
//    message d'erreur
//    Saisir un numéro de mois : 3
//            31 jours
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Saisir un numéro de mois : ");
    int mois;
    mois = scanner.nextInt();

    if (mois == 0 || mois > 12 ){
        System.out.println("Choisir un mois valide.");
    } else if (mois == 1){
        System.out.println(31);
    } else if (mois == 2){
        System.out.println(28);
    } else if (mois == 3){
        System.out.println(31);
    } else if (mois == 4){
        System.out.println(30);
    } else if (mois == 5){
        System.out.println(31);
    } else if (mois == 6){
        System.out.println(30);
    } else if (mois == 7){
        System.out.println(31);
    } else if (mois == 8){
        System.out.println(31);
    } else if (mois == 9){
        System.out.println(30);
    } else if (mois == 10) {
        System.out.println(31);
    } else if (mois == 11){
        System.out.println(30);
    } else if (mois == 12){
        System.out.println(31);
    }

        }
}

