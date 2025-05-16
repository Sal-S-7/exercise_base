package org.example.exercisesPoo.exTPPapeterie.Classes;

public class Line {
    private Article article;
    private int quantity;

    public Line(Article article, int quantity) {
        this.article = article;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return article.getPrice() * quantity;
    }

    public void showLine() {
        System.out.println(quantity + "\n" + article.getReference() + " \n " + article.getName()
                + " \n " + article.getPrice() + "€  " + "\n " + " Total : " + getTotalPrice() + "€");
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantity() {
        return quantity;
    }
}

