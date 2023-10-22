package com.example.carmanagement.dao.entities;

import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "car_id") // Nom de la colonne de clé étrangère dans la table de réservation
    private Car car; // Référence à la voiture réservée
    private  String userId;
}