package com.geekster.restaurantManagement.services;


import com.geekster.restaurantManagement.modules.Foods;
import com.geekster.restaurantManagement.modules.Restaurant;
import com.geekster.restaurantManagement.repository.IFoodRepository;
import com.geekster.restaurantManagement.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IFoodRepository iFood;

    public String addRestaurant(Restaurant restaurant) {


        List<Foods> foodList =restaurant.getFoods();
        for(Foods foodObj : foodList){
            foodObj.setRestaurant(restaurant);
        }
        iRestaurantRepository.save(restaurant);
        return "Restaurant added Successfully!!";
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return iRestaurantRepository.findAll();
    }
}
