package com.pizzarestaurant.store.mapper;

import com.pizzarestaurant.store.dto.DriverDTO;
import com.pizzarestaurant.store.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
}
