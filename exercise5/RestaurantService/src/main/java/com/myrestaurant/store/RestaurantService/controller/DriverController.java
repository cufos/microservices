package com.myrestaurant.store.RestaurantService.controller;

import com.myrestaurant.store.RestaurantService.dto.DriverDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Driver API")
public interface DriverController {
    @ApiOperation("Add new data")
    public DriverDTO save(@RequestBody DriverDTO driver);

    @ApiOperation("Find by Id")
    public DriverDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<DriverDTO> list();

    @ApiOperation("Update one data")
    public DriverDTO update(@RequestBody DriverDTO dto, @PathVariable("id") Long id);
}