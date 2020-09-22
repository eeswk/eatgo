package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.applicaiton.RestaurantService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Restaurant> list(@RequestParam("region") String region, @RequestParam("category") Long categoryId) {
/*
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/
        //List<Restaurant> restaurants = restaurantRepository.findAll();
        //String region = "Seoul";
//        Long categoryId = 1L;
        List<Restaurant> restaurants = restaurantService.getRestaurants(region, categoryId);
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

}

