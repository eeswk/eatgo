package kr.co.fastcampus.eatgo.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kr.co.fastcampus.eatgo.applicaiton.UserService;
import kr.co.fastcampus.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //1. User List
    //2. User create -> 회원가입
    //3. User update
    //4. User delete -> level: 0
    //(1: customer, 2: restaurat)


    @GetMapping("/users")
    public List<User> list() {
        List<User> users = userService.getUsers();
        return users;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {
        User user = userService.addUser(resource.getEmail(), resource.getName());
        URI url = new URI("/users/"+ user.getId());
        return ResponseEntity.created(url).body("{}");
    }

    @PatchMapping("/users/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody User resource) throws URISyntaxException {
        userService.updateUser(id, resource.getEmail(), resource.getName(), resource.getLevel());
        return "{}";
    }

    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deactivateUser(id);
        return "{}";
    }
}
