package in.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cg.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}