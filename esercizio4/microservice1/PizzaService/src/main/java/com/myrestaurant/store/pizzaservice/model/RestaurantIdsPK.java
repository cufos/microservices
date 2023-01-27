package com.myrestaurant.store.pizzaservice.model;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RestaurantIdsPK implements Serializable {
  private Long restaurantId;
  private Long pizzaId;
}
