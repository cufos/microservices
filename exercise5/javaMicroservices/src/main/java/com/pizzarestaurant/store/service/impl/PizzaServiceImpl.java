package com.pizzarestaurant.store.service.impl;

import com.pizzarestaurant.store.dao.PizzaRepository;
import com.pizzarestaurant.store.model.Pizza;
import com.pizzarestaurant.store.model.Restaurant;
import com.pizzarestaurant.store.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
  private final PizzaRepository pizzaRepository;

  @Override
  public Pizza save(Pizza entity) {
    return pizzaRepository.save(entity);
  }

  @Override
  public List<Pizza> save(List<Pizza> entities) {
    return (List<Pizza>) pizzaRepository.saveAll(entities);
  }

  @Override
  public void deleteById(Long id) {
    pizzaRepository.deleteById(id);
  }

  @Override
  public Optional<Pizza> findById(Long id) {
    return pizzaRepository.findById(id);
  }

  @Override
  public List<Pizza> findAll() {
    return (List<Pizza>) pizzaRepository.findAll();
  }

  @Override
  public Pizza update(Pizza entity, Long id) {
    Optional<Pizza> optional = pizzaRepository.findById(id);

    if (optional.isPresent()){
      return save(entity);
    }
    return null;
  }

  @Override
  public List<Pizza> findByRestaurantId(Long restaurantId) {
    List<Pizza> pizzas = pizzaRepository.findByRestaurantsIn(
      List.of(Restaurant.builder()
        .id(restaurantId)
        .build()
      )
    );
    return pizzas;
  }
}
