package in.cg.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.entities.FoodItem;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

 List<FoodItem> findByRestaurantId(Long restaurantId);

}
