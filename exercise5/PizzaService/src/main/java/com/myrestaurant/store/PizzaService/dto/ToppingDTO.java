package com.myrestaurant.store.PizzaService.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class ToppingDTO {

    private Long id;

    private String name;

}