package com.myrestaurant.store.PizzaService.controller;

import com.myrestaurant.store.PizzaService.dto.PizzaDTO;
import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pizza API")
public interface PizzaController {

    @ApiOperation("Add pizzas to restaurant")
    public List<PizzaDTO> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS);

    @ApiOperation("Add new data")
    public PizzaDTO save(@RequestBody PizzaDTO pizza);

    @ApiOperation("Find by Id")
    public PizzaDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Find by Restaurant ID")
    public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long restaurantId);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<PizzaDTO> list();

    @ApiOperation("Update one data")
    public PizzaDTO update(@RequestBody PizzaDTO dto, @PathVariable("id") Long id);

}