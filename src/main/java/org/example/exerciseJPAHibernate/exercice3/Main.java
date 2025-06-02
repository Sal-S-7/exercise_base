package org.example.exerciseJPAHibernate.exercice3;

import org.example.exerciseJPAHibernate.exercice3.utils.ProductManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_product");
        EntityManager em = emf.createEntityManager();

        try {
            ProductManager manager = new ProductManager(em);
            manager.menu();
        } finally {
            em.close();
            emf.close();
        }
    }
}
