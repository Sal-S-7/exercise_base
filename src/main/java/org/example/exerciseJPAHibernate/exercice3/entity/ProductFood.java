package org.example.exerciseJPAHibernate.exercice3.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ProductFood extends Product {

    @Temporal(TemporalType.DATE)
    private Date expiryDate;
}
