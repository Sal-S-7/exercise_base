package org.example.exerciseHibernate.exercice1.util;

import org.example.exerciseHibernate.exercice1.entity.Produit;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Produit.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
