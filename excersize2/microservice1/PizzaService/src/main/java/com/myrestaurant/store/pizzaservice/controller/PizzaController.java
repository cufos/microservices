package com.myrestaurant.store.pizzaservice.controller;

import com.myrestaurant.store.pizzaservice.dto.PizzaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pizza API")
public interface PizzaController {

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
