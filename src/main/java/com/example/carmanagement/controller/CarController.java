package com.example.carmanagement.controller;


import com.example.carmanagement.dao.entities.Car;
import com.example.carmanagement.dao.entities.ReservationCar;
import com.example.carmanagement.dao.entities.User;
import com.example.carmanagement.servicesCar.CarServiceImpl;
import com.example.carmanagement.servicesCar.ReservationCarServiceImpl;
import com.example.carmanagement.servicesCar.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/car")
public class CarController {
    @Autowired
    private CarServiceImpl carServices;
    @Autowired
    private ReservationCarServiceImpl reservationCarService;
    @Autowired
    private userService userService;
    @GetMapping("/cars")
    //car
    public List<Car> getAllCar() {
        return carServices.getAllCar();
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return carServices.getCarById(id);
    }

    @PostMapping("/addcar")
    public Car createCar(@RequestBody Car car) {
        return carServices.createCar(car);
    }

    @PutMapping("/updatecar/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
        return carServices.updateCar(id, car);
    }

    @DeleteMapping("/deletecar/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carServices.deleteCar(id);
    }




    //reservation

    @GetMapping("/reservationscars")
    public List<ReservationCar> getAllReservationsCars() {
        return reservationCarService.getAllReservationsCars();
    }

    @GetMapping("/reservationcar/{id}")
    public ReservationCar getReservationCarById(@PathVariable Integer id) {
        return reservationCarService.getReservationCarById(id);
    }

    @PostMapping("/addreservationcar/{userId}")
    public ReservationCar createReservationCar(@RequestBody ReservationCar reservationCar, @PathVariable String userId) {
        User user = userService.getUserById(userId);
        reservationCar.setUserId(user.get_id());
        return reservationCarService.createReservationCar(reservationCar,userId);
    }

    @PutMapping("/updatereservationcar/{id}")
    public ReservationCar updateReservationCar(@PathVariable Integer id, @RequestBody ReservationCar reservationCar) {
        return reservationCarService.updateReservationCar(id, reservationCar);
    }

    @DeleteMapping("/deletereservationcar/{id}")
    public void deleteReservationCar(@PathVariable Integer id) {
        reservationCarService.deleteReservationCar(id);
    }




}
