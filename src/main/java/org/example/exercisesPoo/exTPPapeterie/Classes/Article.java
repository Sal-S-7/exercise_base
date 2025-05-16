package org.example.exercisesPoo.exTPPapeterie.Classes;

public class Article {
        private String reference;

        public Article(String reference) {
            this.reference = reference;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getName() {
            return "";
        }

        public double getPrice() {
            return 0;
        }

        @Override
        public String toString() {
            return "Réference : " + reference;
        }
    }
