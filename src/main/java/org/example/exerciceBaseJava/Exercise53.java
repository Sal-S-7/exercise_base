package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise53 {
    public static void main(String[] args) {

//    Exercice : Somme des carrés
//1. Écrire un programme avec les variables suivantes : a, b
//2. Afficher la somme des carrés de ces deux nombres
//    Saisir a :
//            2
//    saisir b :
//            3
//    La somme des carrés de a et b est : 13

        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le premier nombre");

        a = scanner.nextInt();

        int carreA = a * a;

        System.out.println("Entrer le deuxième nombre");

        b = scanner.nextInt();

        int carreB = b * b;

        int carretotal = carreA + carreB;

        System.out.println("La somme des carrés de a et b est :"+ " "+ carretotal);
    }
}
