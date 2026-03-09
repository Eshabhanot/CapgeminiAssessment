package in.cg.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.FoodItemDTO;
import in.cg.service.FoodItemService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    // Add food item to restaurant (Admin only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{restaurantId}/fooditems")
    public FoodItemDTO addFoodItem(
            @PathVariable Long restaurantId,
            @RequestBody FoodItemDTO dto) {

        return foodItemService.addFoodItem(restaurantId, dto);
    }

    // Get food items by restaurant
    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItemDTO> getFoodItems(@PathVariable Long restaurantId) {

        return foodItemService.getFoodItems(restaurantId);
    }
}
