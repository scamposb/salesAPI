package com.scamposb.salesAPI.controller.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProductPriceResponse {
    private final long productID;

    private final int brandID;

    private final int fee;

    private final String startDate;

    private final String endDate;

    private final Double price;
}
