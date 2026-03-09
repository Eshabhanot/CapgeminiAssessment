package in.cg.service;



import java.util.List;

import in.cg.dto.FoodItemDTO;


public interface FoodItemService {

    FoodItemDTO addFoodItem(Long restaurantId, FoodItemDTO dto);

    List<FoodItemDTO> getFoodItems(Long restaurantId);

}
