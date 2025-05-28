package org.example.exerciseJPAHibernate.exercice2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String model;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identification_id")
    private Identification identification;

    public Computer(String model, Identification identification) {
        this.model = model;
        this.identification = identification;
    }

}
