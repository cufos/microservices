package com.restaurant.store.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RestaurantIdsDTO {

  private Long restaurantId;

  private Long pizzaId;
}
