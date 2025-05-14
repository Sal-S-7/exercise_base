package org.example.exerciceBaseJava;

import java.util.Scanner;

public class Exercice71Correction {
    /*
    1.Créer une variable caractere
    2.Affecter une valeur à la variable caractere
    3.A l'aide des structures conditionnelles, déterminer si le caractère est une consonne ou une voyelle
     */
    public static void main(String[] args) {
        // Scanner pour permettre la lecture de la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        char caractere;

        System.out.println("Veuillez saisir un caractere : ");
        caractere = scanner.nextLine().toLowerCase().charAt(0);

        String voyelles = "aeiouy";


        // verfication qu'il s'agit d'une lettre
        if(caractere >= 'a' && caractere <= 'z'){
            System.out.println("c'est une lettre");
            // if(voyelles.contains(Character.toString(caractere))){
            if(caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u' || caractere == 'y' ){
                System.out.println("Le caractere est une voyelle");
            }else {
                System.out.println("Le caractere n'est pas une voyelle");
            }
        }else {
            System.out.println("pas une lettre !!!!");
        }



    }
}