package com.pizzarestaurant.store.dao;

import com.pizzarestaurant.store.model.Pizza;
import com.pizzarestaurant.store.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
  List<Pizza> findByRestaurantsIn(List<Restaurant> restaurants);
}
