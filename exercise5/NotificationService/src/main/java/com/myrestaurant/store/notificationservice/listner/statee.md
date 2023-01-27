    private final EmailService emailService;

    private final SMSService smsService;

    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
    public void onNotifyPizzasToRestaurantAdded(String message) {
        log.info("Into onAddPizzasToRestaurant method.");
        emailService.sendMessagge(message);
        smsService.sendMessagge(message);
    }