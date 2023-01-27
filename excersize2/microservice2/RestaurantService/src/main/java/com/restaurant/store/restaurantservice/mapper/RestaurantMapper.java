package com.restaurant.store.restaurantservice.mapper;


import com.restaurant.store.restaurantservice.dto.RestaurantDTO;
import com.restaurant.store.restaurantservice.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO> {
}
