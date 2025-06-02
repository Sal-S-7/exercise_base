package org.example.exerciseJPAHibernate.exercice2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String macAddress;

    private String ipAddress;

    public Identification(String macAddress, String ipAddress) {
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
    }
}
