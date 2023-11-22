package com.scamposb.salesAPI.infrastructure.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProductPriceRequest {
    private final Long productID;

    private final Integer brandID;

    private final String requestedDate;

}
