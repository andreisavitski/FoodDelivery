package by.pvt.fooddelivery.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private Long id;
    private Long orderId;
    private Long foodId;
    private Integer quantity;
}
