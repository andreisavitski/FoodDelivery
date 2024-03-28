package by.pvt.fooddelivery.service.messagebroker;

import by.pvt.fooddelivery.dto.OrderMessageDTO;

public interface ProducerService {
    void sendMessage(OrderMessageDTO order);
}
