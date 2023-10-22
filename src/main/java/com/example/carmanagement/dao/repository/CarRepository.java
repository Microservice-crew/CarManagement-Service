package com.example.carmanagement.dao.repository;

import com.example.carmanagement.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
