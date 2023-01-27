package com.pizzarestaurant.store.service.impl;

import com.pizzarestaurant.store.dao.DriverRepository;
import com.pizzarestaurant.store.model.Driver;
import com.pizzarestaurant.store.model.Pizza;
import com.pizzarestaurant.store.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
  private final DriverRepository driverRepository;

  @Override
  public Driver save(Driver entity) {
    return driverRepository.save(entity);
  }

  @Override
  public List<Driver> save(List<Driver> entities) {
    return driverRepository.saveAll(entities);
  }

  @Override
  public void deleteById(Long id) {
    driverRepository.deleteById(id);
  }

  @Override
  public Optional<Driver> findById(Long id) {
    return driverRepository.findById(id);
  }

  @Override
  public List<Driver> findAll() {
    return driverRepository.findAll();
  }

  @Override
  public Driver update(Driver entity, Long id) {
    Optional<Driver> driver = driverRepository.findById(id);
    if (driver.isPresent()){
      return save(entity);
    }
    return null;
  }
}
