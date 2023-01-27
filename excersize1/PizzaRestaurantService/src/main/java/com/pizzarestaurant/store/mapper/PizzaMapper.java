package com.pizzarestaurant.store.mapper;

import com.pizzarestaurant.store.dto.PizzaDTO;
import com.pizzarestaurant.store.model.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO>{

}
