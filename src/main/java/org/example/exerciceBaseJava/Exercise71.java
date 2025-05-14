package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise71 {
//    Exercice : Voyelle ou consonne
//1. Créer une variable caractere
//2. Affecter une valeur à la variable caractere
//3. A l'aide des structures conditionnelles, déterminer si le caractère
//    est une consonne ou une voyelle
//    Saisir un caractère : c
//    Le caractère saisi est une consonne

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String caractere;
        System.out.print("Saisir une lettre : ");
        caractere = scanner.next();

        if (caractere.length() == 1) {
            char lettre = caractere.charAt(0);

            if (lettre == 'a' || lettre == 'e' || lettre == 'i' || lettre == 'o' || lettre == 'u' || lettre == 'y') {
                System.out.println("Le caractère saisi est une voyelle.");
            } else if (lettre > 'a' && lettre <= 'z') {
                System.out.println("Le caractère saisi est une consonne.");
            } else {
                System.out.println("Ce n'est pas une lettre de l'alphabet.");
            }
        } else {
            System.out.println("Veuillez saisir un seul caractère.");
        }
    }
}
