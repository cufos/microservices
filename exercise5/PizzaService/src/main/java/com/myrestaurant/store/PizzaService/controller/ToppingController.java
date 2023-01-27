package com.myrestaurant.store.PizzaService.controller;

import com.myrestaurant.store.PizzaService.dto.ToppingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Topping API")
public interface ToppingController {

    @ApiOperation("Add new data")
    public ToppingDTO save(@RequestBody ToppingDTO topping);

    @ApiOperation("Find by Id")
    public ToppingDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<ToppingDTO> list();

    @ApiOperation("Update one data")
    public ToppingDTO update(@RequestBody ToppingDTO dto, @PathVariable("id") Long id);

}