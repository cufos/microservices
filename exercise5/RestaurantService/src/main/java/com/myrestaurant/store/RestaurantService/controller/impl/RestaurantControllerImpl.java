package com.myrestaurant.store.RestaurantService.controller.impl;

import com.myrestaurant.store.RestaurantService.FeignProxyClient.PizzaServiceProxyClient;
import com.myrestaurant.store.RestaurantService.controller.RestaurantController;
import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.RestaurantService.mapper.RestaurantMapper;
import com.myrestaurant.store.RestaurantService.model.Restaurant;
import com.myrestaurant.store.RestaurantService.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurants")
@RestController
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    private final PizzaServiceProxyClient pizzaServiceProxyClient;

    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;

    @Override
    @PostMapping("/addPizzas")
    public List<Object> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
        // RestTemplate restTemplate = new RestTemplate();
        // List<Object> result = List.of(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS, Object[].class));
        List<Object> result = pizzaServiceProxyClient.addPizzasToRestaurant(restaurantIdsDTOS);
        restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);
        return null;
    }

    @Override
    @GetMapping("/pizzas/{restaurantId}")
    public List<Object> getPizzasByRestaurantId(@PathVariable("restaurantId") Long restaurantId) {
        // RestTemplate restTemplate = new RestTemplate();
        // List<Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));
        List<Object> _result = pizzaServiceProxyClient.getPizzasToByRestaurant(restaurantId);
        return _result;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        restaurantService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<RestaurantDTO> list() {
        return restaurantMapper.asDTOList(restaurantService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id) {
        Restaurant restaurant = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.update(restaurant, id));
    }
}