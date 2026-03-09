package in.cg.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.dto.FoodItemDTO;
import in.cg.entities.FoodItem;
import in.cg.exception.ResourceNotFoundException;
import in.cg.repository.FoodItemRepository;
import in.cg.repository.RestaurantRepository;


@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public FoodItemDTO addFoodItem(Long restaurantId, FoodItemDTO dto) {

        restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        FoodItem item = new FoodItem();

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(dto.getCategory());
        item.setRestaurantId(restaurantId);

        foodItemRepository.save(item);

        return dto;
    }

    @Override
    public List<FoodItemDTO> getFoodItems(Long restaurantId) {

        List<FoodItem> items = foodItemRepository.findByRestaurantId(restaurantId);

        return items.stream().map(i -> {

            FoodItemDTO dto = new FoodItemDTO();
            dto.setName(i.getName());
            dto.setPrice(i.getPrice());
            dto.setCategory(i.getCategory());

            return dto;

        }).toList();
    }
}