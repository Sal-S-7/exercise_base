package org.example.exerciseJPAHibernate.exercice1.entity;

import org.example.exerciseJPAHibernate.exercice1.model.DietType;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

    private String arrivalDate;

    public Animals() {}

    public Animals(String name, int age, DietType dietType, String arrivalDate) {
        this.name = name;
        this.age = age;
        this.dietType = dietType;
        this.arrivalDate = arrivalDate;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public DietType getDietType() { return dietType; }
    public String getArrivalDate() { return arrivalDate; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDietType(DietType dietType) { this.dietType = dietType; }
    public void setArrivalDate(String arrivalDate) { this.arrivalDate = arrivalDate; }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dietType=" + dietType +
                ", arrivalDate='" + arrivalDate + '\'' +
                '}';
    }
}