package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev","prod"})
public class DataSourceConfigMix {
  public DataSourceConfigMix(){
    System.out.println("Into DataSourceConfigMix class");
  }
}
