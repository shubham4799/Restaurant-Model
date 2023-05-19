package com.geekster.restaurantManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInOutputData {

    private String message;
    private String tokenUuid;

}
