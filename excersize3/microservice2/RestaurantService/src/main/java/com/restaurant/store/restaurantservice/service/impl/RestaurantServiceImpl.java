package com.restaurant.store.restaurantservice.service.impl;

import com.restaurant.store.restaurantservice.dao.RestaurantRepository;
import com.restaurant.store.restaurantservice.model.Restaurant;
import com.restaurant.store.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
  private final RestaurantRepository restaurantRepository;

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

}
