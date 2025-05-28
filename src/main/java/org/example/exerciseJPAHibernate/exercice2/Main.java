package org.example.exerciseJPAHibernate.exercice2;

import org.example.exerciseJPAHibernate.exercice2.entity.*;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2_computer");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        GraphicCard graphicCard = new GraphicCard();
        graphicCard.setName("RTX 5090");
        em.persist(graphicCard);

        Processor processor = new Processor();
        processor.setName("Ryzen 9 9950X3D");
        em.persist(processor);

        OperatingSystem os = new OperatingSystem();
        os.setName("Windows 11");
        em.persist(os);

        Identification identification = new Identification();
        identification.setMacAddress("21:22:21:22:21:22");
        identification.setIpAddress("222.333.4.555");

        Computer computer = new Computer();
        computer.setModel("Gaming Rig 3");
        computer.setIdentification(identification);
        computer.setProcessor(processor);
        computer.setOperatingSystem(os);
        computer.setGraphicCard(graphicCard);
        em.persist(computer);

        et.commit();

        Computer computerFind = em.find(Computer.class, computer.getId());
        if (computerFind != null) {
            System.out.println("Found computer: " + computerFind.getModel());
        } else {
            System.out.println("No computer found.");
        }

        // UPDATE
//        try {
//            em.getTransaction().begin();
//            Computer computerUpdate = em.getReference(Computer.class, computer.getId());
//            computerUpdate.setModel("CHROMEBOOK");
//            em.getTransaction().commit();
//        } catch (EntityNotFoundException ex) {
//            System.out.println("Update failed: " + ex.getMessage());
//        }

        // DELETE
//        Computer computerDelete = em.find(Computer.class, computer.getId());
//        if (computerDelete != null) {
//            em.getTransaction().begin();
//            em.remove(computerDelete);
//            em.getTransaction().commit();
//        }

        em.close();
        emf.close();
    }
}
