package com.pizzarestaurant.store.service.impl;

import com.pizzarestaurant.store.dao.PizzaRepository;
import com.pizzarestaurant.store.dao.RestaurantRepository;
import com.pizzarestaurant.store.model.Pizza;
import com.pizzarestaurant.store.model.Restaurant;
import com.pizzarestaurant.store.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
  private final RestaurantRepository restaurantRepository;
  private final PizzaRepository pizzaRepository;

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
    if (restaurant.isPresent()){
      return save(entity);
    }
    return null;
  }

  @Override
  public Restaurant addPizzasToRestaurant(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }

}
