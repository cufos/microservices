package com.pizzarestaurant.store.controller.impl;

import com.pizzarestaurant.store.controller.PizzaController;
import com.pizzarestaurant.store.dto.PizzaDTO;
import com.pizzarestaurant.store.mapper.PizzaMapper;
import com.pizzarestaurant.store.model.Pizza;
import com.pizzarestaurant.store.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {

  private final PizzaService pizzaService;

  private final PizzaMapper pizzaMapper;

  @Override
  @GetMapping("/restaurant/{id}")
  public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long restaurantId) {
    List<Pizza> pizzas = pizzaService.findByRestaurantId(restaurantId);
    return pizzaMapper.asDTOList(pizzas);
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
}
