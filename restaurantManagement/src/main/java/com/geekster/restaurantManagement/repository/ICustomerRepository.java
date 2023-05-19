package com.geekster.restaurantManagement.repository;

import com.geekster.restaurantManagement.modules.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Customer findFirstByCustomerEmailId(String userEmailId);
}
