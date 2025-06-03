package org.example.exerciseHibernate.exercice1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marque;
    private String reference;

    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    private double prix;
    private int stock;

}

