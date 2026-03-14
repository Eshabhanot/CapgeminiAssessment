package in.cg.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.main.client.RentalClient;
import in.cg.main.dto.RentalCarDTO;

import java.util.List;



@Service
public class PassengerService {

    @Autowired
    private RentalClient rentalClient;

    public List<RentalCarDTO> getCarDetails() {

        return rentalClient.getCars();

    }
}