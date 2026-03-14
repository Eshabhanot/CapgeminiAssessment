package in.cg.main.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.entities.RentalCar;
import in.cg.main.repository.RentalCarRepository;

import java.util.List;


@Service
public class RentalCarService {

    @Autowired
    private RentalCarRepository
    repository;

    public RentalCar addCar(RentalCar car) {

        return repository.save(car);
    }

    public List<RentalCar> getAllCars() {

        return repository.findAll();
    }

}