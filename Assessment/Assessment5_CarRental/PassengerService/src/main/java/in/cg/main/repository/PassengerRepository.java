package in.cg.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cg.main.entities.RentalCar;

@Repository
public interface PassengerRepository extends JpaRepository<RentalCar, Long> {

}