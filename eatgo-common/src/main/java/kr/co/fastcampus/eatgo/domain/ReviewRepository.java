package kr.co.fastcampus.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<Review> findById(Long id);
    Review save(Review review);

    List<Review> findAllByRestaurantId(Long restaurantId);
    List<Review> findAll();

}
