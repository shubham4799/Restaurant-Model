package com.geekster.restaurantManagement.repository;

import com.geekster.restaurantManagement.modules.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant , Long> {
}
