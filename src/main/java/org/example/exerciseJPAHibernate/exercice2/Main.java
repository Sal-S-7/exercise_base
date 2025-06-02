package org.example.exerciseJPAHibernate.exercice2;

import org.example.exerciseJPAHibernate.exercice2.dao.ComputerDAO;
import org.example.exerciseJPAHibernate.exercice2.dao.ProjectDAO;
import org.example.exerciseJPAHibernate.exercice2.entity.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2_computer");
        EntityManager em = emf.createEntityManager();
        ComputerDAO dao = new ComputerDAO();

//        EntityTransaction et = em.getTransaction();
//        et.begin();
//
//        GraphicCard graphicCard = new GraphicCard();
//        graphicCard.setName("RTX 5090");
//        em.persist(graphicCard);
//
//        Processor processor = new Processor();
//        processor.setName("Ryzen 9 9950X3D");
//        em.persist(processor);
//
//        OperatingSystem os = new OperatingSystem();
//        os.setName("Windows 11");
//        em.persist(os);
//
//        Identification identification = new Identification();
//        identification.setMacAddress("21:22:21:22:21:22");
//        identification.setIpAddress("222.333.4.555");
//
//        Computer computer = new Computer();
//        computer.setModel("Gaming Rig 3");
//        computer.setIdentification(identification);
//        computer.setProcessor(processor);
//        computer.setOperatingSystem(os);
//        computer.setGraphicCard(graphicCard);
//        em.persist(computer);
//
//        et.commit();
//
//        Computer computerFind = em.find(Computer.class, computer.getId());
//        if (computerFind != null) {
//            System.out.println("Found computer: " + computerFind.getModel());
//        } else {
//            System.out.println("No computer found.");
//        }

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

        em.getTransaction().begin();

        Computer computer = new Computer();
        computer.setModel("Test 3");
        em.persist(computer);

        Project project = new Project();
        project.setProjectName("Test 3 Nom");
        project.setDescription("Test 3 Description");

        project.getComputers().add(computer);
        computer.getProjects().add(project);

        dao.associateComputerWithProjects(3, Arrays.asList(2, 3));
        List<Project> projects = dao.getProjectsByComputerId(3);
        projects.forEach(p -> System.out.println(p.getProjectName()));

        em.persist(project);
        em.getTransaction().commit();

        Project savedProject = em.find(Project.class, project.getId());
        System.out.println("Ordinateurs liés au projet TEST: " + savedProject.getComputers().size());
//
//        dao.dissociateComputerFromProjects(2, Arrays.asList(2, 3));
//        List<Project> projects = dao.getProjectsByComputerId(2);
//        projects.forEach(p -> System.out.println(p.getProjectName()));

        em.close();
        emf.close();
    }
}
