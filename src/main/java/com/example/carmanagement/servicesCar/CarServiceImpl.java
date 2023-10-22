package com.example.carmanagement.servicesCar;

import com.example.carmanagement.dao.entities.Car;
import com.example.carmanagement.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Integer id, Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingCar.setAnnee(car.getAnnee());
            existingCar.setPrix(car.getPrix());
            existingCar.setColor(car.getColor());
            existingCar.setBrand(car.getBrand());

            // Enregistrez les modifications dans la base de données
            return carRepository.save(existingCar);
        }
        return null;
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
