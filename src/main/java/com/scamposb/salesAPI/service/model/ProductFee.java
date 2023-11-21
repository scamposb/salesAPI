package com.scamposb.salesAPI.service.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductFee {
    private final long productID;

    private final int brandID;

    private final int fee;

    private final List<Date> applicationDates;

    private final double price;

    private final String currency;

    private final int priority; 

}
