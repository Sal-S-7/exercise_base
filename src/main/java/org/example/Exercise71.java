package org.example;

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
        caractere = String.valueOf(scanner.nextInt());
        //'a','e', 'i', 'o', 'u', 'y'
        if (caractere.equals('a') || caractere.equals('e')||caractere.equals('i')||caractere.equals('o') || caractere.equals('u') || caractere.equals('y')) {
            System.out.println("Le caractère saisi est une voyelle.");
        // "b","c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
        } else if (caractere.equals (caractere.equals('b'))) {
            System.out.println("Le caractère saisi est une consonne.");
        }
    }
}
