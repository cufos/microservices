package com.myrestaurant.store.RestaurantService.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class DriverDTO {

    private Long id;

    private String name;

}