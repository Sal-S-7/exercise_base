package org.example.exerciseJPAHibernate.exercice2;

import org.example.exerciseJPAHibernate.exercice2.entity.Computer;
import org.example.exerciseJPAHibernate.exercice2.entity.Identification;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2_computer");
        EntityManager em = emf.createEntityManager();

        // CREATE
        EntityTransaction et = em.getTransaction();
        et.begin();

        Identification id = new Identification("NOUVELLE ADRESSE", "NOUVELLE ADRESSE");
        Computer computer = new Computer("NOUVEAU PC", id);

        em.persist(computer);

        // FIND
        Computer computerFind = em.find(Computer.class, 3);
        if (computerFind != null) {
            System.out.println(computerFind);
        } else {
            System.out.println("No computer found.");
        }

        // UPDATE
        try{
            Computer computerUpdate = em.getReference(Computer.class,3);
            em.getTransaction().begin();
            computerUpdate.setModel("NEW PC");
            em.getTransaction().commit();
        }catch (EntityNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        // DELETE
        Computer computerDelete = em.find(Computer.class,7);
        if(computerDelete != null){
            em.getTransaction().begin();
            em.remove(computerDelete);
            em.getTransaction().commit();
        }

        et.commit();
        em.close();
        emf.close();


    }

}