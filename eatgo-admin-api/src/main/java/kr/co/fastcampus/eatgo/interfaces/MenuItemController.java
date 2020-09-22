package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.applicaiton.MenuItemService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable Long restaurantId, @RequestBody List<MenuItem> menuItems) {

        menuItemService.bulkUpdate(restaurantId, menuItems);
        return "";
    }

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        return menuItemService.getMenuItems(restaurantId);
    }
}
