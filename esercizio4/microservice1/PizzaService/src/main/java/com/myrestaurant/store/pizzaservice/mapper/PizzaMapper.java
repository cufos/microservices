package com.myrestaurant.store.pizzaservice.mapper;

import com.myrestaurant.store.pizzaservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO> {

}
