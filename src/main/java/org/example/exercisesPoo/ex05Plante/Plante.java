package org.example.exercisesPoo.ex05Plante;

public class Plante {

    private String nom;
    private int hauteur;
    private String couleur;

    public Plante(String nom,int hauteur, String couleur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Mon nom est " + nom + ", je possède une hauteur de : " + hauteur + "cm et " +
                " une couleur de couleur " + couleur + ".";
    }
}


