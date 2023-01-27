package com.restaurant.store.restaurantservice.service;

import com.restaurant.store.restaurantservice.dto.RestaurantIdsDTO;
import com.restaurant.store.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService extends GenericService<Restaurant,Long> {

  public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);
}
