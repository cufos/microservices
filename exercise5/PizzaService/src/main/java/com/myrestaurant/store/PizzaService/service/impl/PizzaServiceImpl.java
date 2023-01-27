package com.myrestaurant.store.PizzaService.service.impl;

import com.myrestaurant.store.PizzaService.dao.PizzaRepository;
import com.myrestaurant.store.PizzaService.dao.RestaurantIdsRepository;
import com.myrestaurant.store.PizzaService.model.Pizza;
import com.myrestaurant.store.PizzaService.model.RestaurantIds;
import com.myrestaurant.store.PizzaService.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    private final RestaurantIdsRepository restaurantIdsRepository;

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.pizzas-added-routingkey}")
    private String pizzasToRestaurantAddRoutingKey;

    @Value("${app.rabbitmq.notify-pizzas-added-routingkey}")
    private String notifyPizzasToRestaurantAddRoutingKey;

    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List<RestaurantIds> restaurantIds = restaurantIdsRepository.findByRestaurantId(restaurantId);
        List<Pizza> pizzas = new ArrayList<Pizza>(restaurantIds.size());
        for (RestaurantIds el : restaurantIds) {
            pizzas.add(pizzaRepository.findById(el.getPizzaId()).get());
        }
        return pizzas;
    }

    @Override
    public List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds) {
        log.info("into addPizzasToRestaurant method!");
        List<Pizza> pizzas = new ArrayList<>();
        for (RestaurantIds el : restaurantIds) {
            pizzas.add(pizzaRepository.findById(el.getPizzaId()).get());
        }
        restaurantIdsRepository.saveAll(restaurantIds);
        rabbitTemplate.convertAndSend("", pizzasToRestaurantAddRoutingKey , pizzas);

        String message = "Added n. " + pizzas.size() + " pizzas!";

        rabbitTemplate.convertAndSend("", notifyPizzasToRestaurantAddRoutingKey, message);
        return pizzas;
    }

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
    @Transactional(readOnly = true)
    public Optional<Pizza> findById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pizza> findAll() {
        return (List<Pizza>) pizzaRepository.findAll();
    }

    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional<Pizza> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}