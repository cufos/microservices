package com.myrestaurant.store.PizzaService.builder;

import com.myrestaurant.store.PizzaService.dto.ToppingDTO;
import com.myrestaurant.store.PizzaService.model.Topping;

import java.util.Arrays;
import java.util.List;

public class ToppingBuilder {
    public static List<ToppingDTO> getListDTO() {
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
                mozzarella,
                pomodoro,
                basilico
        );
    }

    public static List<Topping> getListEntities() {
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
                mozzarella,
                pomodoro,
                basilico
        );
    }

    public static ToppingDTO getDTO() {
        return ToppingDTO.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
    }

    public static Topping getEntity() {
        return Topping.builder()
                .id(1L)
                .name("Mozzarella")
                .build();
    }
}
