package com.geekster.restaurantManagement.repository;

import com.geekster.restaurantManagement.modules.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderFood ,Long> {
}

