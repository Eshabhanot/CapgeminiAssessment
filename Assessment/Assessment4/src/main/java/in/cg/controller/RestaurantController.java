package in.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.RestaurantDTO;
import in.cg.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Get all restaurants with pagination
    @GetMapping
    public Page<RestaurantDTO> getAllRestaurants(
            @RequestParam int page,
            @RequestParam int size) {

        return restaurantService.getAllRestaurants(page, size);
    }

    // Add restaurant (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public RestaurantDTO addRestaurant(@Valid @RequestBody RestaurantDTO dto) {

        return restaurantService.addRestaurant(dto);
    }
}
