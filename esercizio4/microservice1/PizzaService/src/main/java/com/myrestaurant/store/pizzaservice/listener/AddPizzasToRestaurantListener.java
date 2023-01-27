package com.myrestaurant.store.pizzaservice.listener;

import com.myrestaurant.store.pizzaservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzaservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzaservice.mapper.RestaurantIdsMapper;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AddPizzasToRestaurantListener {

  private final PizzaService pizzaService;
  private final RestaurantIdsMapper restaurantIdsMapper;

  @RabbitListener(queues = {"${app.rabbitmq.add-pizzas-routingKey}"})
  public void addPizzaToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOs) {
    pizzaService.addPizzasToRestaurant(restaurantIdsMapper.asEntityList(restaurantIdsDTOs));
  }

}
