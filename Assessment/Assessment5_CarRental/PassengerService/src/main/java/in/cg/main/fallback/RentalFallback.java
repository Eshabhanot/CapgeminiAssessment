package in.cg.main.fallback;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import in.cg.main.client.RentalClient;
import in.cg.main.dto.RentalCarDTO;

@Component
public class RentalFallback implements RentalClient {

    @Override
    public List<RentalCarDTO> getCars() {

        List<RentalCarDTO> list = new ArrayList<>();

        RentalCarDTO car = new RentalCarDTO();

        car.setName("Service unavailable");
        car.setType("Try later");
        car.setPrice(0);

        list.add(car);

        return list;
    }
}