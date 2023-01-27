package com.restaurant.store.restaurantservice.service.impl;

import com.restaurant.store.restaurantservice.dao.RestaurantRepository;
import com.restaurant.store.restaurantservice.dto.RestaurantIdsDTO;
import com.restaurant.store.restaurantservice.model.Restaurant;
import com.restaurant.store.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final RabbitTemplate rabbitTemplate;
  private final RestaurantRepository restaurantRepository;

  @Value("${app.rabbitmq.add-pizzas-routingKey}")
  private String addPizzasToRestaurantRoutingKey;


  @Override
  public Restaurant save(Restaurant entity) {
    return restaurantRepository.save(entity);
  }

  @Override
  public List<Restaurant> save(List<Restaurant> entities) {
    return restaurantRepository.saveAll(entities);
  }

  @Override
  public void deleteById(Long id) {
    restaurantRepository.deleteById(id);
  }

  @Override
  public Optional<Restaurant> findById(Long id) {
    return restaurantRepository.findById(id);
  }

  @Override
  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }

  @Override
  public Restaurant update(Restaurant entity, Long id) {
    Optional<Restaurant> restaurant = restaurantRepository.findById(id);
    if (restaurant.isPresent()) {
      return save(entity);
    }
    return null;
  }

  @Override
  public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
    rabbitTemplate.convertAndSend("", addPizzasToRestaurantRoutingKey , restaurantIdsDTOS);
  }
}
