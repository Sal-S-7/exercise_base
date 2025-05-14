package org.example.exerciceBaseJava;

public class Exercice97 {
    /*
    1.Ecrire un programme qui permet de vérifier si 2 tableaux sont égaux
    2.Vérifier la taille des tableaux et l'ordre des valeurs
     */
    public static void main(String[] args) {
        int[] tableau1 = {1, 4, 2, 3, 5};
        int[] tableau2 = {1, 4, 2, 3};
        boolean isEqual = true;

        if(tableau1.length == tableau2.length){
            for (int indice = 0;indice < tableau1.length; indice++){
                if(tableau1[indice] != tableau2[indice]){
                    isEqual = false;
                    break;
                }
            }
        }else {
            isEqual = false;
        }


        if(isEqual){
            System.out.println("Les tableaux sont égaux");
        }else {
            System.out.println("Les tableaux ne sont pas égaux");
        }
    }
}
