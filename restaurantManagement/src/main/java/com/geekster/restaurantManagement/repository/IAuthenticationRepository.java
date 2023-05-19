package com.geekster.restaurantManagement.repository;
import com.geekster.restaurantManagement.modules.Authentication;
import com.geekster.restaurantManagement.modules.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepository extends JpaRepository<Authentication , Long> {
    Authentication findByCustomer(Customer customerObj);

    Authentication findFirstByAuthenticationToken(String token);
}
