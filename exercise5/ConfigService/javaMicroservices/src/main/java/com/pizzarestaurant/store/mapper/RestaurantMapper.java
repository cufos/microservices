package com.pizzarestaurant.store.mapper;

import com.pizzarestaurant.store.dto.RestaurantDTO;
import com.pizzarestaurant.store.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO>{
}
