package com.example.carmanagement.dao.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer annee;
    private Float prix;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Enumerated(EnumType.STRING)
    private Color color;
}
