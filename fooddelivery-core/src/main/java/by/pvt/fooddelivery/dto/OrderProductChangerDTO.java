package by.pvt.fooddelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class OrderProductChangerDTO {

    private final Long orderId;

    private final Long productId;
}
