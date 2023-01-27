package com.restaurant.store.restaurantservice.controller;

import com.restaurant.store.restaurantservice.dto.RestaurantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Restaurant API")
public interface RestaurantController {

  @ApiOperation("Find all pizzas by restaurant ID")
  public List<Object> getPizzasByRestaurantId(
    @PathVariable("id") Long restaurantId
  );

  @ApiOperation("Add new restaurant")
  public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);

  @ApiOperation("Find restaurant by id")
  public RestaurantDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete by id")
  public void deleteById(@PathVariable("id") Long id);

  @ApiOperation("Find all restaurants")
  public List<RestaurantDTO> list();

  @ApiOperation("Update Restaurant")
  public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id);
}
