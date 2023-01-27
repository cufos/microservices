package com.myrestaurant.store.pizzaservice.mapper;

import com.myrestaurant.store.pizzaservice.dto.ToppingDTO;
import com.myrestaurant.store.pizzaservice.model.Topping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO> {

}
