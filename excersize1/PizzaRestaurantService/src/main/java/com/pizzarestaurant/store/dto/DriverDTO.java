package com.pizzarestaurant.store.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class DriverDTO {
  private Long id;

  private String name;

   // private Set<RestaurantDTO> restaurants = new HashSet<>();
}
