package com.myrestaurant.store.notificationservice.listner.impl;

import com.myrestaurant.store.notificationservice.listner.NotificationListener;
import com.myrestaurant.store.notificationservice.service.LetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("email")
public class LetterListenerImpl implements NotificationListener {
  private final LetterService letterService;

  @Override
  @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
  public void onNotifyPizzaToRestaurantAdded(String message) {
    log.info("Into EmailListener onAddPizzasToRestaurant method.");
    letterService.sendMessagge(message);
  }
}
