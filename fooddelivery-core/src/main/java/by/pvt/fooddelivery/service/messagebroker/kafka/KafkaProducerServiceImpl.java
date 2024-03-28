package by.pvt.fooddelivery.service.messagebroker.kafka;

import by.pvt.fooddelivery.dto.OrderMessageDTO;
import by.pvt.fooddelivery.service.messagebroker.ProducerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Primary
@Service(value = "kafka")
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<Long, OrderMessageDTO> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    @Override
    public void sendMessage(OrderMessageDTO order) {
        kafkaTemplate.send("server.order", order);
        LOGGER.info(String.format("Json message sent -> %s", order));
    }
}
