package kr.co.fastcampus.eatgo.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User save(User user);

    Optional<User> findByEmail(String email);

}
