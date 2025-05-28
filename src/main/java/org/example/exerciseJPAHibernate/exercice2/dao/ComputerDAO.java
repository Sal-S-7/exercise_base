package org.example.exerciseJPAHibernate.exercice2.dao;

import org.example.exerciseJPAHibernate.exercice2.entity.Computer;

import javax.persistence.*;
import java.util.List;

public class ComputerDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2_computer");

    public void create(Computer computer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(computer);
        et.commit();
        em.close();
    }

    public Computer read(int id) {
        EntityManager em = emf.createEntityManager();
        Computer computer = em.find(Computer.class, id);
        em.close();
        return computer;
    }

    public void update(Computer computer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(computer);
        et.commit();
        em.close();
    }

}
