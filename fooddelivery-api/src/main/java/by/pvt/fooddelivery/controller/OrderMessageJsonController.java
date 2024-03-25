package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.OrderMessageDTO;
import by.pvt.fooddelivery.service.rabbitmq.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message/order")
@RequiredArgsConstructor
public class OrderMessageJsonController {

    private final RabbitMQProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody(required = false) OrderMessageDTO order) {
        jsonProducer.sendJsonMessage(order);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
