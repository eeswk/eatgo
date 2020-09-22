package kr.co.fastcampus.eatgo.applicaiton;

import java.util.List;
import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(String email, String name) {
        User newUser = User.builder().email(email).name(name).level(1L).build();

        User user = userRepository.save(newUser);
        return user;
    }

    public User updateUser(Long id, String email, String name, Long level) {
        //TODO: restaurantService 예외처리 참고.
        User user = userRepository.findById(id).orElse(null);

        user.setName(name);
        user.setEmail(email);
        user.setLevel(level);

        //userRepository.save(user);

        return user;
    }

    public User deactivateUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.deactivate();
        return user;
    }
}
