package com.myrestaurant.store.pizzaservice.service.impl;

import com.myrestaurant.store.pizzaservice.dao.PizzaRepository;
import com.myrestaurant.store.pizzaservice.dao.RestaurantIdsRepository;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.model.RestaurantIds;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
  private final PizzaRepository pizzaRepository;
  private final RestaurantIdsRepository restaurantIdsRepository;
  private final RabbitTemplate rabbitTemplate;

  @Value("${app.rabbitmq.pizzas-added-routingKey}")
  private String pizzasToRestaurantAddRoutingKey;

  @Value("${app.rabbitmq.notify-pizzas-added-routingKey}")
  private String notifyPizzasToRestaurantAddRoutingKey;

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
    List<RestaurantIds> restaurantIds = restaurantIdsRepository.findByRestaurantId(restaurantId);
    List<Pizza> pizzas = new ArrayList<>(restaurantIds.size());

    for (RestaurantIds el:restaurantIds) {
      pizzas.add(pizzaRepository.findById(el.getPizzaId()).get());
    }

    return pizzas;
  }

  @Override
  public List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIdsList) {
    List<Pizza> pizzas = new ArrayList<>(restaurantIdsList.size());
    for (RestaurantIds el : restaurantIdsList){
      pizzas.add(pizzaRepository.findById(el.getPizzaId()).get());
    }
    restaurantIdsRepository.saveAll(restaurantIdsList);
    String message = " Added n. " + pizzas.size() + " pizzas!";
    rabbitTemplate.convertAndSend("",pizzasToRestaurantAddRoutingKey,pizzas);
    rabbitTemplate.convertAndSend("",notifyPizzasToRestaurantAddRoutingKey,message );
    return pizzas;
  }
}
