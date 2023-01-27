package com.myrestaurant.store.pizzaservice.dao;

import com.myrestaurant.store.pizzaservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}
