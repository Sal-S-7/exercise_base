package org.example.exercisesPoo.ex04WaterTank;

public class WaterTank {

    private int poids;
    private int capMax;
    private int niveauRemplissage;


    private static float volumeTotal = 0;


    public WaterTank(int poids, int capMax, int niveauRemplissage) {
        this.poids = poids;
        this.capMax = capMax;
        this.niveauRemplissage = niveauRemplissage;
    }

    public void setNiveauRemplissage(int niveauRemplissage) {

        if (niveauRemplissage < 0) {
            this.niveauRemplissage = 0;
        } else if (niveauRemplissage > capMax) {
            this.niveauRemplissage = capMax;
        } else {
            this.niveauRemplissage = niveauRemplissage;
        }

        volumeTotal += niveauRemplissage;
    }


    public void remplir(int montant) {
        if (montant < 0) {
            System.out.println("Opération non valide.");
            return;
        }
        int nouveauNiveau = this.niveauRemplissage + montant;
        if (nouveauNiveau > capMax) {
            setNiveauRemplissage(capMax);
        } else {
            setNiveauRemplissage(nouveauNiveau);
        }
    }


    public void vider(int montant) {
        if (montant < 0) {
            System.out.println("Opération non valide.");
            return;
        }
        int nouveauNiveau = this.niveauRemplissage - montant;
        if (nouveauNiveau < 0) {
            setNiveauRemplissage(0);
        } else {
            setNiveauRemplissage(nouveauNiveau);
        }
    }


    public double getPoidsTotal() {
        double poidsEau = this.niveauRemplissage * 1.0;
        return this.poids + poidsEau;
    }


    public static float getVolumeTotal() {
        return volumeTotal;
    }
}
