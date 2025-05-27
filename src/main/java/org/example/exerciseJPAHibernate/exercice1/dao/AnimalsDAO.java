package org.example.exerciseJPAHibernate.exercice1.dao;

import org.example.exerciseJPAHibernate.exercice1.entity.Animals;
import org.example.exerciseJPAHibernate.exercice1.model.DietType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalsDAO {

    private final EntityManager entityManager;

    public AnimalsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Animals createAnimal(String name, int age, DietType dietType, String arrivalDate) {
        Animals animal = new Animals(name, age, dietType, arrivalDate);
        entityManager.getTransaction().begin();
        entityManager.persist(animal);
        entityManager.getTransaction().commit();
        return animal;
    }

    public Animals findById(Long id) {
        return entityManager.find(Animals.class, id);
    }

    public List<Animals> findByName(String name) {
        TypedQuery<Animals> query = entityManager.createQuery(
                "SELECT a FROM Animals a WHERE a.name = :name", Animals.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Animals> findByDiet(DietType dietType) {
        TypedQuery<Animals> query = entityManager.createQuery(
                "SELECT a FROM Animals a WHERE a.dietType = :dietType", Animals.class);
        query.setParameter("dietType", dietType);
        return query.getResultList();
    }
}
