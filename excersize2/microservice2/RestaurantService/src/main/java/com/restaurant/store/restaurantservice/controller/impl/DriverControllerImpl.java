package com.restaurant.store.restaurantservice.controller.impl;


import com.restaurant.store.restaurantservice.controller.DriverController;
import com.restaurant.store.restaurantservice.dto.DriverDTO;
import com.restaurant.store.restaurantservice.mapper.DriverMapper;
import com.restaurant.store.restaurantservice.model.Driver;
import com.restaurant.store.restaurantservice.service.DriverService;
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
