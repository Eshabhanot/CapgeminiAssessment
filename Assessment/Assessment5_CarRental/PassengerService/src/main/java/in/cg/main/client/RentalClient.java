package in.cg.main.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import in.cg.main.dto.RentalCarDTO;
import in.cg.main.fallback.RentalFallback;

import java.util.List;


@FeignClient(name = "carrentals-service", fallback = RentalFallback.class)
public interface RentalClient {

    @GetMapping("/rental/rentalcardetails")
    List<RentalCarDTO> getCars();

}