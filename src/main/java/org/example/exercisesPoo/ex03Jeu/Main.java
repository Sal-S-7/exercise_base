package org.example.exercisesPoo.ex03Jeu;

public class Main {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("WarriorDu59");

        for (int i = 1; i <= 20; i++) {
            joueur.effectuerUneQuete(i);
        }

        // changement de nom du joueur
        joueur.setNom("LeGigaBossDuJava");
        System.out.println(joueur.getNom());
    }
}