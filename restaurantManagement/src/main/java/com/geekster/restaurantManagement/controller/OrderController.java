package com.geekster.restaurantManagement.controller;


import com.geekster.restaurantManagement.modules.OrderFood;
import com.geekster.restaurantManagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public Iterable<OrderFood> getAllOrder(){
        return orderService.getAllOrderdFood();
    }

}
