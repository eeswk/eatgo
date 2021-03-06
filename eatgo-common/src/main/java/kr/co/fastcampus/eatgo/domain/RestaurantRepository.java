package kr.co.fastcampus.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    //List<Restaurant> findByAddressContaining(String region);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);

    List<Restaurant> findByAddressContainingAndCategoryId(String seoul, Long categoryId);
}
