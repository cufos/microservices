package com.pizzarestaurant.store.dao;

import com.pizzarestaurant.store.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
