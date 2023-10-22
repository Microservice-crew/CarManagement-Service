package com.example.carmanagement.controller;


import com.example.carmanagement.dao.entities.Car;
import com.example.carmanagement.dao.entities.ReservationCar;
import com.example.carmanagement.dao.entities.User;
import com.example.carmanagement.servicesCar.userService;
import com.example.carmanagement.servicesCar.ReservationCarServiceImpl;
import com.example.carmanagement.servicesCar.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/reservation/car")
public class ReservationCarController  {
    @Autowired
    private ReservationCarServiceImpl reservationCarService;
    @Autowired
    private userService userService;
    @GetMapping
    public List<ReservationCar> getAllReservationsCars() {
        return reservationCarService.getAllReservationsCars();
    }

    @GetMapping("/{id}")
    public ReservationCar getReservationCarById(@PathVariable Integer id) {
        return reservationCarService.getReservationCarById(id);
    }

    @PostMapping("/{userId}")
    public ReservationCar createReservationCar(@RequestBody ReservationCar reservationCar, @PathVariable String userId) {
        User user = userService.getUserById(userId);
        reservationCar.setUserId(user.get_id());
        return reservationCarService.createReservationCar(reservationCar,userId);
    }

    @PutMapping("/{id}")
    public ReservationCar updateReservationCar(@PathVariable Integer id, @RequestBody ReservationCar reservationCar) {
        return reservationCarService.updateReservationCar(id, reservationCar);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationCar(@PathVariable Integer id) {
        reservationCarService.deleteReservationCar(id);
    }

}
