package org.example.exerciseJPAHibernate.exercice2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String model;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identification_id")
    private Identification identification;


    @ManyToOne
    @JoinColumn(name = "processor_id")
    private Processor processor;


    @ManyToOne
    @JoinColumn(name = "os_id")
    private OperatingSystem operatingSystem;

    @ManyToOne
    @JoinColumn(name = "graphiccard_id")
    private GraphicCard graphicCard;

    @ManyToMany(mappedBy = "computers")
    private List<Project> projects = new ArrayList<>();


    public Computer(String model, Identification identification) {
        this.model = model;
        this.identification = identification;
    }




}
