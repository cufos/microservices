package com.myrestaurant.store.RestaurantService.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class RestaurantDTO {

    private Long id;

    private String name;

    private String address;

    private String city;

    private Set<DriverDTO> drivers;

}