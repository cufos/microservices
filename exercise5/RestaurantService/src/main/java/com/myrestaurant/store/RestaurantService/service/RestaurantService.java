package com.myrestaurant.store.RestaurantService.service;

import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.RestaurantService.model.Restaurant;

import java.util.List;

public interface RestaurantService extends GenericService<Restaurant, Long> {

    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);

}