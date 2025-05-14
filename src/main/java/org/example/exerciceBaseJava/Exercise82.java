package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercise82 {
    public static void main(String[] args) {
        // Scanner pour permettre la lecture de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier : ");
        int nombre = scanner.nextInt();

        //Premiere boucle qui gere de debut de la suite
        for (int cpt = 1 ; cpt < nombre / 2 + 1; cpt++){
            String result = nombre + " = " + cpt;
            int somme = cpt;
            //Seconde boucle qui permet de calculer le reste de la suite
            for (int suite = cpt +1; cpt < nombre /2 * 2;suite++){
                result += " + " + suite;
                somme += suite;

            // Si on dépasse, on sort de la boucle
                if (somme > nombre){
                    break;
                }
            // Si la somme est egale au nombre, on affiche le resultat et on sort de la boucle
            else if  (somme == nombre){
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
