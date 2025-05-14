package org.example.exercisesPoo.ex05Plante;

public class Arbre extends Plante{

        public int circonference;

        public Arbre(String nom, int hauteur, String couleur, int circonference) {
            super(nom, hauteur, couleur);
            this.circonference = circonference;

        }
    }
