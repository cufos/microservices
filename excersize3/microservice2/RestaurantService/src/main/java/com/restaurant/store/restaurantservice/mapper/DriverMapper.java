package com.restaurant.store.restaurantservice.mapper;


import com.restaurant.store.restaurantservice.dto.DriverDTO;
import com.restaurant.store.restaurantservice.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
}
