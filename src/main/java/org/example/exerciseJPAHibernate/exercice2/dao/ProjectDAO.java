package org.example.exerciseJPAHibernate.exercice2.dao;

import org.example.exerciseJPAHibernate.exercice2.entity.Computer;
import org.example.exerciseJPAHibernate.exercice2.entity.Project;

import javax.persistence.*;
import java.util.List;

public class ProjectDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");

    public void createProject(Project project) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }

    public Project getProject(int id) {
        EntityManager em = emf.createEntityManager();
        Project project = em.find(Project.class, id);
        em.close();
        return project;
    }

    public List<Project> getAllProjects() {
        EntityManager em = emf.createEntityManager();
        List<Project> projects = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        em.close();
        return projects;
    }

    public void updateProject(Project project) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteProject(int id) {
        EntityManager em = emf.createEntityManager();
        Project project = em.find(Project.class, id);
        if (project != null) {
            em.getTransaction().begin();
            em.remove(project);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void addComputerToProject(int projectId, Computer computer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Project project = em.find(Project.class, projectId);
        Computer managedComputer = em.find(Computer.class, computer.getId());

        if (project != null && managedComputer != null) {
            project.addComputer(managedComputer);
            em.merge(project);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void removeComputerFromProject(int projectId, Computer computer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Project project = em.find(Project.class, projectId);
        Computer managedComputer = em.find(Computer.class, computer.getId());

        if (project != null && managedComputer != null) {
            project.removeComputer(managedComputer);
            em.merge(project);
        }

        em.getTransaction().commit();
        em.close();
    }

    public List<Project> getProjectsByComputer(int computerId) {
        EntityManager em = emf.createEntityManager();
        List<Project> projects = em.createQuery(
                        "SELECT p FROM Project p JOIN p.computers c WHERE c.id = :computerId", Project.class)
                .setParameter("computerId", computerId)
                .getResultList();
        em.close();
        return projects;
    }

    public List<Computer> getComputersByProject(int projectId) {
        EntityManager em = emf.createEntityManager();
        Project project = em.find(Project.class, projectId);
        List<Computer> computers = project != null ? project.getComputers() : null;
        em.close();
        return computers;
    }
}
