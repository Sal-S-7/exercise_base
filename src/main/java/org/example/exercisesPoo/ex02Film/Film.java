package org.example.exercisesPoo.ex02Film;

public class Film {

    private String titre;
    private String realisateur;
    private String annee;
    private String genre;

    public Film(String titre, String realisateur, String annee, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.annee = annee;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Le film du nom de " + titre + " réalisé par " + realisateur +
                " en année " + annee + " du genre de " + genre;
    }
}

