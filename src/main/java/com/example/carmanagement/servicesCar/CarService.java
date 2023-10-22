package com.example.carmanagement.servicesCar;


import com.example.carmanagement.dao.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getCarById(Integer id);
    Car createCar(Car car);
    Car updateCar(Integer id, Car car);
    void deleteCar(Integer id);
}
