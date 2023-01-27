package com.pizzarestaurant.store.service;

import com.pizzarestaurant.store.model.Restaurant;

import java.util.Set;

public interface RestaurantService extends GenericService<Restaurant,Long> {
  Restaurant addPizzasToRestaurant(Restaurant restaurant);
}
