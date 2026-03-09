package in.cg.service;

import org.springframework.data.domain.Page;

import in.cg.dto.RestaurantDTO;

public interface RestaurantService {

    Page<RestaurantDTO> getAllRestaurants(int page, int size);

    RestaurantDTO addRestaurant(RestaurantDTO dto);

}
