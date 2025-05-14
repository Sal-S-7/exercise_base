package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise55 {
    public static void main(String[] args) {
//        Exercice : volume d'un cercle
//        1. Créer un programme qui permet de calculer le volume d'un cône
//        2. La formule est la suivante : 1/3 × π × r² × h
//        Saisir un rayon : 4
//        Saisir une hauteur : 7
//        Le volume du cône est de 117,29 cm3
        double rayon, hauteur, volume;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le rayon : ");
        rayon = scanner.nextDouble();

        System.out.println("Saisir la hauteur : ");
        hauteur = scanner.nextDouble();

        volume = (1.0 / 3.0) * Math.PI * rayon * rayon * hauteur;

        System.out.printf("Le volume du cône est de %.2f", volume);


            }
        }
