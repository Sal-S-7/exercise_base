package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise68 {
    public static void main(String[] args) {
//        Exercice : majeur ou mineur
//        1. Créer une variable age
//        2. Affecter une valeur à la variable age
//        3. Créer une condition qui permet d'afficher si la personne est
//        majeure ou mineure
//        Saisir un âge : 23
//        Vous êtes majeur, vous pouvez rentrer dans le club.
        int age;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Entrez votre âge : ");
        age = scanner.nextInt();
        if (age >=18) {
            System.out.println("Vous êtes majeur, vous pouvez rentrer dans le club.");
        } else {
            System.out.println("Vous êtes mineur, vous ne pouvez pas rentrer dans le club.");
        }
    }
}
