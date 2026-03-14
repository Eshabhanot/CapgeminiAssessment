package in.cg.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.cg.main.dto.RentalCarDTO;
import in.cg.main.service.PassengerService;

import java.util.List;


@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService service;

    @GetMapping("/passengerdetails")
    public List<RentalCarDTO> getPassengerDetails() {

        return service.getCarDetails();
    }
}