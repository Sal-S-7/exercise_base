package org.example.exerciseJPAHibernate.exercice2.dao;

import org.example.exerciseJPAHibernate.exercice2.entity.Computer;
import org.example.exerciseJPAHibernate.exercice2.entity.Project;

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

    public void associateComputerWithProjects(int computerId, List<Integer> projectIds) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Computer computer = em.find(Computer.class, computerId);
        if (computer != null) {
            for (Integer projectId : projectIds) {
                Project project = em.find(Project.class, projectId);
                if (project != null) {
                    project.addComputer(computer);
                }
            }
        }

        em.getTransaction().commit();
        em.close();
    }

    public void dissociateComputerFromProjects(int computerId, List<Integer> projectIds) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Computer computer = em.find(Computer.class, computerId);
        if (computer != null) {
            for (Integer projectId : projectIds) {
                Project project = em.find(Project.class, projectId);
                if (project != null) {
                    project.removeComputer(computer);
                }
            }
        }

        em.getTransaction().commit();
        em.close();
    }

    public List<Project> getProjectsByComputerId(int computerId) {
        EntityManager em = emf.createEntityManager();
        Computer computer = em.find(Computer.class, computerId);
        List<Project> projects = null;

        if (computer != null) {
            projects = computer.getProjects();
            projects.size();
        }

        em.close();
        return projects;
    }

}
