package com.example.carmanagement.servicesCar;

import com.example.carmanagement.dao.entities.Car;
import com.example.carmanagement.dao.entities.ReservationCar;

import java.util.List;

public interface ReservationCarService {
    List<ReservationCar> getAllReservationsCars();
    ReservationCar getReservationCarById(Integer id);
    ReservationCar createReservationCar(ReservationCar reservationCar, String userId);
    ReservationCar updateReservationCar(Integer id, ReservationCar reservationCar);
    void deleteReservationCar(Integer id);
}
