package com.myrestaurant.store.pizzaservice.dao;

import com.myrestaurant.store.pizzaservice.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends JpaRepository<Topping,Long> {
}
