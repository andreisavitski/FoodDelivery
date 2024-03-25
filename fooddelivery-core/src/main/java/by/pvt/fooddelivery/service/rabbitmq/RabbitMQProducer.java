package by.pvt.fooddelivery.service.rabbitmq;

import by.pvt.fooddelivery.dto.OrderMessageDTO;

public interface RabbitMQProducer {
    void sendJsonMessage(OrderMessageDTO order);
}
