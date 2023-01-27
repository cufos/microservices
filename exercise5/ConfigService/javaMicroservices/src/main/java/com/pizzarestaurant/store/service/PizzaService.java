package com.pizzarestaurant.store.service;

import com.pizzarestaurant.store.model.Pizza;

import java.util.List;

public interface PizzaService extends GenericService<Pizza,Long>{

  List<Pizza> findByRestaurantId(Long restaurantId);
}
