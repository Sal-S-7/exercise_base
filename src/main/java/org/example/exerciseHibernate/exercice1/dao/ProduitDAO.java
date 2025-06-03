package org.example.exerciseHibernate.exercice1.dao;

import org.example.exerciseHibernate.exercice1.entity.Produit;
import org.example.exerciseHibernate.exercice1.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitDAO {

    public void create(Produit produit) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(produit);
            transaction.commit();
        }
    }

    public Produit findById(int id) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        }
    }

    public void update(Produit produit) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(produit);
            transaction.commit();
        }
    }

    public void delete(int id) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Produit produit = session.get(Produit.class, id);
            if (produit != null) {
                session.remove(produit);
            }
            transaction.commit();
        }
    }

    public List<Produit> findAll() {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            String hql = "FROM Produit";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            return query.list();
        }
    }

    public List<Produit> findByGreaterPrice(double prixMin) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            String hql = "FROM Produit p WHERE p.prix > :prixMin";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            query.setParameter("prixMin", prixMin);
            return query.list();
        }
    }

    public List<Produit> findByBetweenDate(Date debut, Date fin) {
        try (Session session = SessionFactorySingleton.getSessionFactory().openSession()) {
            String hql = "FROM Produit p WHERE p.dateAchat BETWEEN :debut AND :fin";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            query.setParameter("debut", debut);
            query.setParameter("fin", fin);
            return query.list();


        }
    }
}