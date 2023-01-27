package com.myrestaurant.store.RestaurantService.controller;

import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Restaurant API")
public interface RestaurantController {

    @ApiOperation("Add pizzas to the restaurant")
    public List<Object> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS);

    @ApiOperation("Find all pizzas by restaurant ID")
    public List<Object> getPizzasByRestaurantId(@PathVariable("id") Long restaurantId);

    @ApiOperation("Add new data")
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurant);

    @ApiOperation("Find by Id")
    public RestaurantDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<RestaurantDTO> list();

    @ApiOperation("Update one data")
    public RestaurantDTO update(@RequestBody RestaurantDTO dto, @PathVariable("id") Long id);
}