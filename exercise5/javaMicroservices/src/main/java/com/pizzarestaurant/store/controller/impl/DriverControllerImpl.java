package com.pizzarestaurant.store.controller.impl;

import com.pizzarestaurant.store.controller.DriverController;
import com.pizzarestaurant.store.dto.DriverDTO;
import com.pizzarestaurant.store.mapper.DriverMapper;
import com.pizzarestaurant.store.model.Driver;
import com.pizzarestaurant.store.model.Restaurant;
import com.pizzarestaurant.store.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverControllerImpl implements DriverController {
  private final DriverService driverService;
  private final DriverMapper driverMapper;

  @Override
  @PostMapping
  public DriverDTO save(@RequestBody DriverDTO driverDTO) {
    Driver driver = driverMapper.asEntity(driverDTO);

    return driverMapper.asDTO(driverService.save(driver));
  }

  @Override
  @GetMapping("/{id}")
  public DriverDTO findById(@PathVariable("id") Long id) {
    Driver driver = driverService.findById(id).orElse(null);
    return driverMapper.asDTO(driver);
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    driverService.deleteById(id);
  }

  @Override
  @GetMapping
  public List<DriverDTO> list() {
    return driverMapper.asDTOList(driverService.findAll());
  }

  @Override
  @PutMapping("/{id}")
  public DriverDTO update(@RequestBody DriverDTO driverDTO,@PathVariable("id") Long id) {
    Driver driver = driverMapper.asEntity(driverDTO);
    return driverMapper.asDTO(driverService.update(driver,id));
  }
}
