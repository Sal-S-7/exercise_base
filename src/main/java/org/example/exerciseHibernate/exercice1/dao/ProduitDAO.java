package org.example.exerciseHibernate.exercice1.dao;

import org.example.exerciseHibernate.exercice1.entity.Produit;
import org.example.exerciseHibernate.exercice1.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitDAO {

    public void create(Produit produit) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(produit);
            tx.commit();
        }
    }

    public Produit findById(int id) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        }
    }

    public void update(Produit produit) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(produit);
            tx.commit();
        }
    }

    public void delete(int id) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Produit produit = session.get(Produit.class, id);
            if (produit != null) {
                session.remove(produit);
            }
            tx.commit();
        }
    }
}
