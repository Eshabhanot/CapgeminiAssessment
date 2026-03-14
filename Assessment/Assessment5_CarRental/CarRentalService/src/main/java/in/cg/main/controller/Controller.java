package in.cg.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.cg.main.entities.RentalCar;
import in.cg.main.service.RentalCarService;

import java.util.List;


@RestController
@RequestMapping("/rental")
public class Controller {

    @Autowired
    private RentalCarService service;

    @PostMapping("/addcar")
    public RentalCar addCar(@RequestBody RentalCar car) {

        return service.addCar(car);
    }

    @GetMapping("/rentalcardetails")
    public List<RentalCar> getCars() {

        return service.getAllCars();
    }

}