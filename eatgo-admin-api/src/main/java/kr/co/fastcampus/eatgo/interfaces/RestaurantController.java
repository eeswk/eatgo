package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.applicaiton.RestaurantService;
import kr.co.fastcampus.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    /*
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuRepository;
    */
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> list() {
/*
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/
        //List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        // 기본정보 + 메뉴정보

        /*
        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuRepository.findAllByRestraurantId(id);
        restaurant.setMenuItems(menuItems);
         */
        //restaurant.addMenuItem(new MenuItem("kimchi"));

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant resource) throws URISyntaxException {
        Restaurant restaurant = restaurantService.addRestaurant(
                Restaurant.builder()
                        .name(resource.getName())
                        .address(resource.getAddress())
                        .build());

        URI url = new URI("/restaurants/"+ restaurant.getId());
        //URI url = new URI("/restaurants/1234");
        return ResponseEntity.created(url).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid @RequestBody Restaurant restaurant) {
        String name = restaurant.getName();
        String address = restaurant.getAddress();
        restaurantService.updateRestaurant(id, name, address);
        return "{}";
    }
}

