package com.myrestaurant.store.PizzaService.builder;

import com.myrestaurant.store.PizzaService.dto.PizzaDTO;
import com.myrestaurant.store.PizzaService.dto.ToppingDTO;
import com.myrestaurant.store.PizzaService.model.Pizza;
import com.myrestaurant.store.PizzaService.model.Topping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaBuilder {
    public static List<PizzaDTO> getListDTO() {
        ToppingDTO mozzarella = ToppingDTO.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
        ToppingDTO pomodoro = ToppingDTO.builder()
                .id(2L)
                .name("Pomodoro")
                .build();
        ToppingDTO basilico = ToppingDTO.builder()
                .id(3L)
                .name("Basilico")
                .build();
        return Arrays.asList(
                PizzaDTO.builder().id(1L)
                        .name("Margherita")
                        .favorite(false)
                        .toppings(Stream.of(
                                        mozzarella,
                                        pomodoro,
                                        basilico
                                ).collect(Collectors.toSet())
                        )
                        .build()
        );
    }

    public static List<Pizza> getListEntities() {
        Topping mozzarella = Topping.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
        Topping pomodoro = Topping.builder()
                .id(2L)
                .name("Pomodoro")
                .build();
        Topping basilico = Topping.builder()
                .id(3L)
                .name("Basilico")
                .build();
        return Arrays.asList(
                Pizza.builder().id(1L)
                        .name("Margherita")
                        .favorite(true)
                        .toppings(Stream.of(
                                        mozzarella,
                                        pomodoro,
                                        basilico
                                ).collect(Collectors.toSet())
                        )
                        .build()
        );
    }

    public static PizzaDTO getDTO() {
        ToppingDTO mozzarella = ToppingDTO.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
        ToppingDTO pomodoro = ToppingDTO.builder()
                .id(2L)
                .name("Pomodoro")
                .build();
        ToppingDTO basilico = ToppingDTO.builder()
                .id(3L)
                .name("Basilico")
                .build();
        return PizzaDTO.builder().id(1L)
                .name("Margherita")
                .favorite(false)
                .toppings(Stream.of(
                                mozzarella,
                                pomodoro,
                                basilico
                        ).collect(Collectors.toSet())
                )
                .build();
    }

    public static Pizza getEntity() {
        Topping mozzarella = Topping.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
        Topping pomodoro = Topping.builder()
                .id(2L)
                .name("Pomodoro")
                .build();
        Topping basilico = Topping.builder()
                .id(3L)
                .name("Basilico")
                .build();
        return Pizza.builder().id(1L)
                .name("Margherita")
                .favorite(true)
                .toppings(Stream.of(
                                mozzarella,
                                pomodoro,
                                basilico
                        ).collect(Collectors.toSet())
                )
                .build();
    }
}
