package org.example.exercisesPoo.ex01Chaise;

public class Chaise {

    private int nbPieds;
    private String materiau;
    private String couleur;

    public Chaise(int nbPieds, String materiau, String couleur) {
        this.nbPieds = nbPieds;
        this.materiau = materiau;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec " + nbPieds + " pied(s) en " + materiau +
                " de couleur " + couleur + ".";
    }
}
