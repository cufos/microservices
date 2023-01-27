package com.myrestaurant.store.pizzaservice.controller;

import com.myrestaurant.store.pizzaservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzaservice.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pizza API")
public interface PizzaController {

  @ApiOperation("Add pizza to restaurant")
  public List<PizzaDTO> addPizzasToRestaurant(
    @RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS
  );

  @ApiOperation("Add new pizza")
  public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO);

  @ApiOperation("Find pizza by id")
  public PizzaDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete by id")
  public void deleteById(@PathVariable("id") Long id);

  @ApiOperation("Find all pizzas")
  public List<PizzaDTO> list();

  @ApiOperation("Update Pizza")
  public PizzaDTO update(@RequestBody PizzaDTO pizza, @PathVariable("id") Long id);

  @ApiOperation("Find by restaurant id")
  public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long restaurantId);
}
