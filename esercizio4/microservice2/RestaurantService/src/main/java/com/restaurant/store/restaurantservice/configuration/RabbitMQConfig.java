package com.restaurant.store.restaurantservice.configuration;


import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

@Configuration
public class RabbitMQConfig {

  private final CachingConnectionFactory cachingConnectionFactory;

  @Value("${app.rabbitmq.add-pizzas-routingKey}")
  private String addPizzasToRestaurantRoutingKey;

  @Value("${app.rabbitmq.pizzas-added-routingKey}")
  private String pizzasToRestaurantAddedRoutingKey;

  @Value("${app.rabbitmq.notify-pizzas-added-routingKey}")
  private String notifyPizzasToRestaurantAddedRoutingKey;

  public RabbitMQConfig(CachingConnectionFactory cachingConnectionFactory) {
    this.cachingConnectionFactory = cachingConnectionFactory;
  }

  @Bean
  public Queue addPizzasToRestaurantQueue() {
    return QueueBuilder.durable(addPizzasToRestaurantRoutingKey)
      .build();
  }

  @Bean
  public Queue pizzasToRestaurantAddedQueue() {
    return QueueBuilder.durable(pizzasToRestaurantAddedRoutingKey)
      .build();
  }

  @Bean
  public Queue notifyPizzasToRestaurantAddedQueue() {
    return QueueBuilder.durable(notifyPizzasToRestaurantAddedRoutingKey)
      .build();
  }

  @Bean
  public RetryOperationsInterceptor retryInterceptor() {
    return RetryInterceptorBuilder.stateless().maxAttempts(3)
      .backOffOptions(2000, 2.0, 100000)
      .recoverer(new RejectAndDontRequeueRecoverer())
      .build();
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    configurer.configure(factory, cachingConnectionFactory);
    factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
    factory.setAdviceChain(retryInterceptor());
    factory.setDefaultRequeueRejected(false);
    return factory;
  }

  @Bean
  public Jackson2JsonMessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter) {
    RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);
    template.setMessageConverter(converter);
    return template;
  }

}