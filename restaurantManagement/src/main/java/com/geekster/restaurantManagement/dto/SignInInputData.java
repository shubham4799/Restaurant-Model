package com.geekster.restaurantManagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInInputData {
    private String userEmailId;
    private String password;

}