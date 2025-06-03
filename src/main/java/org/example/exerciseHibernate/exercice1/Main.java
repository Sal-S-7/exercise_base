package org.example.exerciseHibernate.exercice1;

import org.example.exerciseHibernate.exercice1.dao.ProduitDAO;
import org.example.exerciseHibernate.exercice1.entity.Produit;
import org.example.exerciseHibernate.exercice1.util.SessionFactorySingleton;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        ProduitDAO dao = new ProduitDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        dao.create(new Produit(0, "Apple", "iPhone 14", sdf.parse("2023-01-10"), 999.99, 10));
        dao.create(new Produit(0, "Samsung", "Galaxy S23", sdf.parse("2023-03-15"), 899.50, 15));
        dao.create(new Produit(0, "Dell", "XPS 15", sdf.parse("2022-10-05"), 1500.00, 5));
        dao.create(new Produit(0, "HP", "Spectre x360", sdf.parse("2021-08-20"), 1200.00, 7));
        dao.create(new Produit(0, "Sony", "PlayStation 5", sdf.parse("2022-12-01"), 499.99, 20));


        Produit p2 = dao.findById(2);
        if (p2 != null) System.out.println("Produit ID 2: " + p2);


        dao.delete(3);
        System.out.println("Produit ID 3 supprimé."
        );


        Produit p1 = dao.findById(1);
        if (p1 != null) {
            p1.setPrix(950.00);
            p1.setStock(12);
            dao.update(p1);
            System.out.println("Produit ID 1 modifié: " + p1);
        }


        SessionFactorySingleton.shutdown();
    }
}
