package com.example.carmanagement.servicesCar;

import com.example.carmanagement.dao.entities.Car;
import com.example.carmanagement.dao.entities.ReservationCar;
import com.example.carmanagement.dao.entities.User;
import com.example.carmanagement.dao.repository.CarRepository;
import com.example.carmanagement.dao.repository.ReservationCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationCarServiceImpl implements ReservationCarService {

    @Autowired
    ReservationCarRepository reservationCarRepository;
    @Autowired
    private userService userService;
    @Override
    public List<ReservationCar> getAllReservationsCars() {
        return reservationCarRepository.findAll();
    }

    @Override
    public ReservationCar getReservationCarById(Integer id) {
        return reservationCarRepository.findById(id).orElse(null);
    }

    @Override
    public ReservationCar createReservationCar(ReservationCar reservationCar, String userId) {
        User user = userService.getUserById(userId);
        reservationCar.setUserId(user.get_id());
        return reservationCarRepository.save(reservationCar);
    }

    @Override
    public ReservationCar updateReservationCar(Integer id, ReservationCar reservationCar) {
        ReservationCar existingReservationCar = reservationCarRepository.findById(id).orElse(null);
        if (existingReservationCar != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingReservationCar.setDateDebut(reservationCar.getDateDebut());
            existingReservationCar.setDateFin(reservationCar.getDateFin());


            // Enregistrez les modifications dans la base de données
            return reservationCarRepository.save(existingReservationCar);
        }
        return null;
    }

    @Override
    public void deleteReservationCar(Integer id) {
        reservationCarRepository.deleteById(id);
    }
}

