package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise70 {
//    Exercice : Maximum de 3 nombres
//1. Créer 3 variables : nombre1, nombre2, nombre3
//2. Affecter des valeurs aux variables
//3. Créer des structures conditionnelles permettant d'afficher le
//    maximum parmis les 3 nombres créésprécédemment
//    Saisir le nombre 1 : 2
//    Saisir le nombre 2 : 5
//    Saisir le nombre 3 : 3
//    La valeur maximale est : 5
public static void main(String[] args) {

    //Bonus d'addition
//    int nombre1,nombre2,nombre3;
//    Scanner scanner = new Scanner(System.in);
//    System.out.print("Saisir le nombre 1: ");
//    nombre1 = scanner.nextInt();
//    int result1 = nombre1;
//    System.out.print("Saisir le nombre 2: ");
//    nombre2 = scanner.nextInt();
//    int result2 = nombre2;
//    System.out.print("Saisir le nombre 3: ");
//    nombre3 = scanner.nextInt();
//    int result3 = nombre3;
//    int resultat = nombre1 + nombre2 + nombre3;
//
//    System.out.println("Le total est de :"+ " " + resultat);

    int nombre1, nombre2, nombre3;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Saisir le nombre 1 : ");
    nombre1 = scanner.nextInt();
    System.out.print("Saisir le nombre 2 : ");
    nombre2 = scanner.nextInt();
    System.out.print("Saisir le nombre 3 : ");
    nombre3 = scanner.nextInt();

    int max = nombre1;

    if (nombre2 > max) {
        max = nombre2;
    }

    if (nombre3 > max) {
        max = nombre3;
    }

    System.out.println("La valeur maximale est : " + max);

    }
}
