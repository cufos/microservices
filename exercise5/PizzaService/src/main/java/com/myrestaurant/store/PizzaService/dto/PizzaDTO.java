package com.myrestaurant.store.PizzaService.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class PizzaDTO {

    private Long id;

    private String name;

    private Set<ToppingDTO> toppings;

    private boolean favorite;

}