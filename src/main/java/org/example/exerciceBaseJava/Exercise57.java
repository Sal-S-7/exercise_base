package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise57 {
//    Exercice : Périmètre et aire d'un carré
//            1. Saisir la longueur du côté du carré et la stocker dans une variable
//2. Calculer l'aire et le périmètre du carré
//    Saisir la longueur d'un côté : 5
//    Le périmètre du carré est de : 20cm
//    L'aire du carré est de : 25cm carré
    public static void main(String[] args) {
        double cote;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir la longueur d'un côté : ");

        cote = scanner.nextDouble();

        double perimetre = 4 * cote;
        double aire = cote * cote;

        System.out.println("Le périmètre du carré est de : " + perimetre + "cm");
        System.out.println("L'aire du carré est de : " + aire + "cm carré");
    }

}
