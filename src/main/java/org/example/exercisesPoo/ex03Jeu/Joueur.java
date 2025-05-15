package org.example.exercisesPoo.ex03Jeu;

public class Joueur {
    private String nom;
    private int niveau;
    private int exp;

    public Joueur(String nom) {
        this.nom = nom;
        this.niveau = 1;
        this.exp = 0;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getExp() {

        return exp;
    }

    public void setExp(int exp) {

        this.exp = exp;
    }

    public void effectuerUneQuete(int numQuete) {
        System.out.println("Le joueur " + nom + " effectue la quête n° " + numQuete);
        exp += 10;

        if (exp >= 100) {
            niveauUp();
        }
    }

    public void niveauUp() {
//        if (xprequired > 100) {
            niveau++;
            exp = 0;
            System.out.println("Le joueur " + nom + " passe au niveau :" + niveau);
//        }
    }
}


