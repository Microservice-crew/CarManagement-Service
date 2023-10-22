package com.example.carmanagement.dao.repository;


import com.example.carmanagement.dao.entities.ReservationCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationCarRepository extends JpaRepository<ReservationCar,Integer> {
}
