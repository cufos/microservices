package com.myrestaurant.store.pizzaservice.dao;

import com.myrestaurant.store.pizzaservice.model.RestaurantIds;
import com.myrestaurant.store.pizzaservice.model.RestaurantIdsPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantIdsRepository extends JpaRepository<RestaurantIds, RestaurantIdsPK>{
  List<RestaurantIds> findByRestaurantId(Long restaurantId);
}