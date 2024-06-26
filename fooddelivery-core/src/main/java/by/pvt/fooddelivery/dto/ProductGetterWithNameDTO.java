package by.pvt.fooddelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ProductGetterWithNameDTO {

    private final String type;

    private final Long restaurantId;

    private final String name;
}
