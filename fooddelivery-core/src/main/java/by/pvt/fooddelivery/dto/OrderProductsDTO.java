package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class OrderProductsDTO {
    private OrderDTO orderDTO;
    private ProductDTO productDTO;
}
