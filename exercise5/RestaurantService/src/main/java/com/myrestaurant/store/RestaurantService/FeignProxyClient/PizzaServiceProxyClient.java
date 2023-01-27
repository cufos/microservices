package com.myrestaurant.store.RestaurantService.FeignProxyClient;


import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "PIZZA-SERVICE")
public interface PizzaServiceProxyClient {

  @PostMapping(value = "/pizzas/restaurants")
  List<Object> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);

  @GetMapping(value = "/pizzas/restaurant/{id}")
  public List<Object> getPizzasToByRestaurant(
    @PathVariable("id") Long restaurantId
  );
}
