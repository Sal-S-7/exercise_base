package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise54 {
//    Exercice : majeur ou mineur
//1. Créer une variable age et lui affecter une valeur
//2. Vérifier si la personne est mineure ou majeure à l'aide des
//    opérateurs logiques
//3. Afficher le résultat
//4. /!\ Ne pas utiliser de structure conditionnelle
//    Saisir un age : 17
//            false
//    Saisir un age : 25
//            true
public static void main(String[] args) {
    int age;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Saisir votre age : ");

    age = scanner.nextInt();

    boolean Majeur = age >= 18;

    System.out.println(Majeur);

    }
}
