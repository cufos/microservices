package com.pizzarestaurant.store.dao;

import com.pizzarestaurant.store.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
