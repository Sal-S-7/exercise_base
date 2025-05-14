package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise72 {

    //        Exercice : Jour de la semaine
    //        1. Créer une variable jour de type entier
    //        2. Affecter une valeur à la variable jour
    //        3. Afficher le jour de la semaine en lettre en fonction du nombre
    //        passé
    //        4. Si le nombre est inférieur à 1 et supérieur à 7, afficher un message
    //        d'erreur
    //        Saisir un jour de la semaine : 5
    //        Vendredi

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un jour de la semaine : ");
        int jour;
        jour = scanner.nextInt();

        if (jour == 0 || jour > 7 ){
            System.out.println("Choisir un jour valide.");
        } else if (jour == 1){
            System.out.println("Lundi");
        } else if (jour == 2){
            System.out.println("Mardi");
        } else if (jour == 3){
            System.out.println("Mercredi");
        } else if (jour == 4){
            System.out.println("Jeudi");
        } else if (jour == 5){
            System.out.println("Vendredi");
        } else if (jour == 6){
            System.out.println("Samedi");
        } else if (jour == 7){
            System.out.println("Dimanche");
        }

    }
}
