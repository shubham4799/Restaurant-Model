package com.geekster.restaurantManagement.repository;

import com.geekster.restaurantManagement.modules.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends JpaRepository<Foods , Long> {
    @Modifying
    @Query(value = "update foods set price = :price where foodsId = :id" , nativeQuery = true)
    void updateFoodById(Long id, Double price);

}