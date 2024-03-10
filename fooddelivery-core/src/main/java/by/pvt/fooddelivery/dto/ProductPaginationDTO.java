package by.pvt.fooddelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ProductPaginationDTO {
    private final Long offset;
    @NonNull
    private final Long pageSize;
    private final String field;
}
