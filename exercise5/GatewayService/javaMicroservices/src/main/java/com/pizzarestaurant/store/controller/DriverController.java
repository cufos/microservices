package com.pizzarestaurant.store.controller;

import com.pizzarestaurant.store.dto.DriverDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Driver API")
public interface DriverController {
  @ApiOperation("Add new driver")
  public DriverDTO save(@RequestBody DriverDTO driverDTO);

  @ApiOperation("Find driver by id")
  public DriverDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete by id")
  public void deleteById(@PathVariable("id") Long id);

  @ApiOperation("Find all drivers")
  public List<DriverDTO> list();

  @ApiOperation("Update driver")
  public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id") Long id);
}
