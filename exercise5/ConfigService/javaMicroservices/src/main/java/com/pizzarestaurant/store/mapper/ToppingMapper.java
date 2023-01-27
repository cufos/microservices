package com.pizzarestaurant.store.mapper;

import com.pizzarestaurant.store.dto.ToppingDTO;
import com.pizzarestaurant.store.model.Topping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO>{

}
