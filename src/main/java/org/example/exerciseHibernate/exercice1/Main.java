package org.example.exerciseHibernate.exercice1;

import org.example.exerciseHibernate.exercice1.dao.ProduitDAO;
import org.example.exerciseHibernate.exercice1.entity.Produit;
import org.example.exerciseHibernate.exercice1.util.SessionFactorySingleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ProduitDAO dao = new ProduitDAO();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        dao.create(new Produit(0, "Test1", "Nintendo Switch 2", sdf.parse("2023-01-10"), 999.99, 10));
//        dao.create(new Produit(0, "Test2", "Galaxy S24 FE", sdf.parse("2023-03-15"), 899.50, 15));
//        dao.create(new Produit(0, "Test3", "Gaming PC", sdf.parse("2022-10-05"), 1500.00, 5));
//        dao.create(new Produit(0, "Test4", "Xbox One", sdf.parse("2021-08-20"), 1200.00, 7));
//        dao.create(new Produit(0, "Test5", "PlayStation 5", sdf.parse("2022-12-01"), 499.99, 20));
//
//
//        Produit p2 = dao.findById(2);
//        if (p2 != null) System.out.println("Produit ID 2: " + p2);
//
//
//        dao.delete(3);
//        System.out.println("Produit ID 3 supprimé."
//        );
//
//
//        Produit p1 = dao.findById(1);
//        if (p1 != null) {
//            p1.setPrix(950.00);
//            p1.setStock(12);
//            dao.update(p1);
//            System.out.println("Produit ID 1 modifié: " + p1);
//        }
//

        List<Produit> tousProduits = dao.findAll();
        System.out.println("Tous les produits :");
        tousProduits.forEach(System.out::println);

        List<Produit> produitsChers = dao.findByGreaterPrice(100);
        System.out.println("Produits avec prix > 100€ :");
        produitsChers.forEach(System.out::println);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date debut = sdf.parse("2022-01-01");
        Date fin = sdf.parse("2022-02-02");

        List<Produit> produitsEntreDates = dao.findByBetweenDate(debut, fin);
        System.out.println("Produits achetés entre " + debut + " et " + fin + " :");
        produitsEntreDates.forEach(System.out::println);

        SessionFactorySingleton.shutdown();
    }
}
