package com.restaurant.store.restaurantservice.dao;


import com.restaurant.store.restaurantservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
