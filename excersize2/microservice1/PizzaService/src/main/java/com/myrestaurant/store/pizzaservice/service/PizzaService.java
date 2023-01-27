package com.myrestaurant.store.pizzaservice.service;

import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.model.RestaurantIds;

import java.util.List;

public interface PizzaService extends GenericService<Pizza,Long> {
  List<Pizza> findByRestaurantId(Long restaurantId);

//  List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds);
}
