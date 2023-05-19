package com.geekster.restaurantManagement.controller;

import com.geekster.restaurantManagement.modules.Restaurant;
import com.geekster.restaurantManagement.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }
}
