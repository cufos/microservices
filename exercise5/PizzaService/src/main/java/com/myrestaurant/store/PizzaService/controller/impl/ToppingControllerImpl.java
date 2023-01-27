package com.myrestaurant.store.PizzaService.controller.impl;

import com.myrestaurant.store.PizzaService.controller.ToppingController;
import com.myrestaurant.store.PizzaService.dto.ToppingDTO;
import com.myrestaurant.store.PizzaService.mapper.ToppingMapper;
import com.myrestaurant.store.PizzaService.model.Topping;
import com.myrestaurant.store.PizzaService.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/toppings")
@RestController
@RequiredArgsConstructor
public class ToppingControllerImpl implements ToppingController {

    private final ToppingService toppingService;
    private final ToppingMapper toppingMapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.save(topping));
    }

    @Override
    @GetMapping("/{id}")
    public ToppingDTO findById(@PathVariable("id") Long id) {
        Topping topping = toppingService.findById(id).orElse(null);
        return toppingMapper.asDTO(topping);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        toppingService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ToppingDTO> list() {
        return toppingMapper.asDTOList(toppingService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public ToppingDTO update(@RequestBody ToppingDTO toppingDTO, @PathVariable("id") Long id) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.update(topping, id));
    }
}