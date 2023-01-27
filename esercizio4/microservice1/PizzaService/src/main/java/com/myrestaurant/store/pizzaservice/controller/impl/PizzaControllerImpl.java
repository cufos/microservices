package com.myrestaurant.store.pizzaservice.controller.impl;

import com.myrestaurant.store.pizzaservice.controller.PizzaController;
import com.myrestaurant.store.pizzaservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzaservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzaservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzaservice.mapper.RestaurantIdsMapper;
import com.myrestaurant.store.pizzaservice.model.Pizza;
import com.myrestaurant.store.pizzaservice.model.RestaurantIds;
import com.myrestaurant.store.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {

  private final PizzaService pizzaService;

  private final PizzaMapper pizzaMapper;

  private final RestaurantIdsMapper restaurantIdsMapper;

  @Override
  @PostMapping("/restaurant")
  public List<PizzaDTO> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
    List<RestaurantIds> _restaurantIds = restaurantIdsMapper.asEntityList(restaurantIdsDTOS);
    return pizzaMapper.asDTOList(pizzaService.addPizzasToRestaurant(_restaurantIds));
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PizzaDTO save(@RequestBody PizzaDTO pizzaTO) {
    Pizza pizza = pizzaMapper.asEntity(pizzaTO);

     // You can use this method
    // Pizza saved = pizzaService.save(pizza);
    // PizzaDTO dto = pizzaMapper.asDTO(saved);

    // or this one it's like a shorthand of the one that is over
    return pizzaMapper.asDTO(pizzaService.save(pizza));
  }

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PizzaDTO findById(@PathVariable("id") Long id) {
    Pizza pizza = pizzaService.findById(id).orElse(null);
    return pizzaMapper.asDTO(pizza);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") Long id) {
    pizzaService.deleteById(id);
  }

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PizzaDTO> list() {
    // this one for remember all the steps and maybe a little bit more legible
    // List<Pizza> pizzas = pizzaService.findAll();
    // pizzaMapper.asDTOList(pizzas);
    return pizzaMapper.asDTOList(pizzaService.findAll());
  }

  @Override
  @PutMapping("/{id}")
  public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO,@PathVariable("id") Long id) {
    Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
    return pizzaMapper.asDTO(pizzaService.update(pizza,id));
  }

  @Override
  @GetMapping("/restaurant/{id}")
  public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long restaurantId) {
    List<Pizza> pizzas = pizzaService.findByRestaurantId(restaurantId);
    return pizzaMapper.asDTOList(pizzas);
  }
}
