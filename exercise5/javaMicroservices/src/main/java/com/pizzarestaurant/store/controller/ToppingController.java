package com.pizzarestaurant.store.controller;

import com.pizzarestaurant.store.dto.ToppingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Topping API")
public interface ToppingController {

  @ApiOperation("Add new topping")
  public ToppingDTO save(@RequestBody ToppingDTO toppingDTO);

  @ApiOperation("Find topping by id")
  public ToppingDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete by id")
  public void deleteById(@PathVariable("id") Long id);

  @ApiOperation("Find all topping")
  public List<ToppingDTO> list();

  @ApiOperation("Update Topping")
  public ToppingDTO update(@RequestBody ToppingDTO toppingDTO, @PathVariable("id") Long id);
}
