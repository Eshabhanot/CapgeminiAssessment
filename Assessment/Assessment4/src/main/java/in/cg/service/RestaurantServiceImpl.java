package in.cg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import in.cg.dto.RestaurantDTO;
import in.cg.entities.Restaurant;
import in.cg.repository.RestaurantRepository;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Page<RestaurantDTO> getAllRestaurants(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);

        return restaurants.map(r -> {
            RestaurantDTO dto = new RestaurantDTO();
            dto.setName(r.getName());
            dto.setLocation(r.getLocation());
            dto.setRating(r.getRating());
            return dto;
        });
    }

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO dto) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        restaurantRepository.save(restaurant);

        return dto;
    }
}