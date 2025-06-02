package org.example.exerciseJPAHibernate.exercice3.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ProductElectronic extends Product {

    private int batterieDuration;
}
