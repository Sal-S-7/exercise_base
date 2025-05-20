package org.example.exercisesPoo.exTPPapeterie.Classes;

    public class Batch extends Article {
        private Article article;
        private int quantity;
        private double sale;

        public Batch(String reference, Article article, int quantity, double sale) {
            super(reference);
            this.article = article;
            this.quantity = quantity;
            this.sale = sale;
        }

        @Override
        public String getName() {
            return "Lot de " + quantity + " " + article.getName();
        }

        public double getPrice() {
            return article.getPrice() * quantity * (1 - sale);
        }

        public Article getArticle() {
            return article;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getSale() {
            return sale;
        }

        @Override
        public String toString() {
            return super.toString() + " - " + getName() + " - Prix total : " + getPrice() + "€"+ " - Pourcentage : "+ getSale() +"%";
        }
    }

