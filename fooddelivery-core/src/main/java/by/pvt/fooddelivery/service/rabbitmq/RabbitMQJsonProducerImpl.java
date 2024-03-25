package by.pvt.fooddelivery.service.rabbitmq;

import by.pvt.fooddelivery.dto.OrderMessageDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducerImpl implements RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducerImpl.class);

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(OrderMessageDTO order) {
        rabbitTemplate.convertAndSend(
                exchange,
                routingJsonKey,
                convertToJsonMessage(order)
        );
        LOGGER.info(String.format("Json message sent -> %s", order));
    }

    private Message convertToJsonMessage(OrderMessageDTO order) {
        String json = "{\"clientId\" : \"" + order.getClientId() + "\"," +
                "\"courierId\" : \"" + order.getCourierId() + "\"," +
                "\"totalCost\" : \"" + order.getTotalCost() + "\"," +
                "\"orderDate\" : \"" + order.getOrderDate() + "\" }";
        return MessageBuilder
                .withBody(json.getBytes())
                .andProperties(MessagePropertiesBuilder.newInstance()
                        .setContentType("application/json")
                        .build())
                .build();
    }
}
