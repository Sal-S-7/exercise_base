package org.example.exerciceBaseJava;

public class Exercice96 {
    /*
    1.Ecrire un programme qui permet de trouver la valeur maximale dans un tableau
     */
    public static void main(String[] args) {
        int[] tableau = {-23, -150, -12, -28, -59, -2,58, 102, 999};
        int max = 0;
        int indMax = 0;

        for (int indice = 0;indice < tableau.length;indice++){
            if(indice == 0){
                max = tableau[indice];
            } else if (tableau[indice] > max) {
                max = tableau[indice];
                indMax = indice;
            }
        }
        System.out.println("La valeur max est "+max+" à l'indice "+indMax+" du tableau.");
    }
}

