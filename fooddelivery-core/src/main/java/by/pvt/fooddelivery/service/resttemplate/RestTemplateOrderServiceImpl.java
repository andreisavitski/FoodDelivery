package by.pvt.fooddelivery.service.resttemplate;

import by.pvt.fooddelivery.dto.OrderLoggerDTO;
import by.pvt.fooddelivery.exception.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RestTemplateOrderServiceImpl implements RestTemplateOrderService {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateOrderServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @Override
    public List<OrderLoggerDTO> getAllOrders() {
        ResponseEntity<OrderLoggerDTO[]> response = restTemplate.getForEntity(
                "http://localhost:8081/order-logger/api/v1/order",
                OrderLoggerDTO[].class
        );
        OrderLoggerDTO[] ordersArray = response.getBody();
        List<OrderLoggerDTO> ordersList = new ArrayList<>();
        assert ordersArray != null;
        Collections.addAll(ordersList, ordersArray);
        return ordersList;
    }

    @Override
    public List<OrderLoggerDTO> getOrdersByClientId(Long clientId) {
        ResponseEntity<OrderLoggerDTO[]> response = restTemplate.getForEntity(
                "http://localhost:8081/order-logger/api/v1/order/client/" + clientId,
                OrderLoggerDTO[].class
        );
        OrderLoggerDTO[] ordersArray = response.getBody();
        List<OrderLoggerDTO> ordersList = new ArrayList<>();
        assert ordersArray != null;
        Collections.addAll(ordersList, ordersArray);
        return ordersList;
    }
}
