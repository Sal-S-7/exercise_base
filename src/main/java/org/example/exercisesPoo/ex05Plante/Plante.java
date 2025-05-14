package org.example.exercisesPoo.ex05Plante;

public class Plante {

    private String nom;
    private int hauteur;
    private String couleur;

    public Plante(int hauteur, String couleur) {
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
        return "Je suis une plante de nom de " + nom + " d'hauteur de : " + hauteur + "cm" +
                " de couleur " + couleur + ".";
    }
}


//1. Créer une classe "Plante" avec les attributs suivants : nom, hauteur et
//couleur des feuilles
//2. Ajouter un constructeur, des getters et des setters pour ces attributs
//3. Créer une méthode pour afficher les informations sur la plante
//4. Créer une classe "Arbre" qui hérite de "Plante" et qui ajoute un attribut
//supplémentaire pour la circonférence du tronc
//5. Surcharger la méthode afficher pour qu'elle ajoute les informations à
//propos de l'arbre
