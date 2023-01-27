package com.restaurant.store.restaurantservice.controller.impl;


import com.restaurant.store.restaurantservice.controller.RestaurantController;
import com.restaurant.store.restaurantservice.dto.RestaurantDTO;
import com.restaurant.store.restaurantservice.mapper.RestaurantMapper;
import com.restaurant.store.restaurantservice.model.Restaurant;
import com.restaurant.store.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {
  private final RestaurantService restaurantService;
  private final RestaurantMapper restaurantMapper;

  @Value("${app.pizza-service-url}")
  private String pizzaServiceUrl;

  @Override
  @GetMapping("/pizzas/{restaurantId}")
  public List<Object> getPizzasByRestaurantId(
    @PathVariable("restaurantId") Long restaurantId
  ) {
      //RestTemplate it's for fetch information from another api
    RestTemplate restTemplate = new RestTemplate();

    return List.of(Objects.requireNonNull(
      restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)
    ));
  }

  @Override
  @PostMapping
  public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO) {
    Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);

    return restaurantMapper.asDTO(restaurantService.save(restaurant));
  }

  @Override
  @GetMapping("/{id}")
  public RestaurantDTO findById(@PathVariable("id") Long id) {
    Restaurant restaurant = restaurantService.findById(id).orElse(null);
    return restaurantMapper.asDTO(restaurant);
  }

  @Override
  @DeleteMapping("/{id")
  public void deleteById(@PathVariable("id") Long id) {
    restaurantService.deleteById(id);
  }

  @Override
  @GetMapping
  public List<RestaurantDTO> list() {
    return restaurantMapper.asDTOList(restaurantService.findAll());
  }

  @Override
  @PutMapping("/{id}")
  public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO,@PathVariable("id") Long id) {
    Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
    return restaurantMapper.asDTO(restaurantService.update(restaurant,id));
  }
}
