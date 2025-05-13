package org.example;

import java.util.Scanner;

public class Exercise75 {
//    Exercice : Lettre, nombre ou caractère spécial
//1. Créer une variable caractere
//2. Affecter une valeur à la variable caractere
//3. Afficher un message en fonction du type du caractère (lettre,
//                                                         nombre, ou caractère spécial)
//    Saisir un caractère : h
//    h est une lettre de l'alphabet

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String caractere;
        System.out.print("Saisir un caractere : ");
        caractere = scanner.next();

//        if (caractere.length() == 1) {
            char cara = caractere.charAt(0);
            int nbr = (int) cara;
            if ((cara >= 'a' && cara <= 'z' || cara >= 'A' && cara <= 'Z')) {
                System.out.println(cara + " est une lettre de l'alphabet.");
            } else if (nbr >= '0' && nbr <= '9') {
                System.out.println(cara + " est un chiffre.");
            } else {
                System.out.println(cara + " est un caractère spécial.");
            }
//        } else {
//            System.out.println("Veuillez saisir un seul caractère.");
//        }

    }
}
