package com.geekster.restaurantManagement.controller;

import com.geekster.restaurantManagement.dto.SignInInputData;
import com.geekster.restaurantManagement.dto.SignInOutputData;
import com.geekster.restaurantManagement.dto.SignUpInputData;
import com.geekster.restaurantManagement.dto.SignUpOutputData;
import com.geekster.restaurantManagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CustomerService customerService;
    //SignUp user:
    @PostMapping("/signup")
    public SignUpOutputData signup(@RequestBody SignUpInputData signUpInputData){
        return customerService.signup(signUpInputData);
    }
    //SignIn user:
    @PostMapping("/signin")
    public SignInOutputData signin(@RequestBody SignInInputData signInInputData){
        return customerService.signin(signInInputData);
    }

}
