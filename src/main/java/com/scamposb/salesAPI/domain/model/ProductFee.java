package com.scamposb.salesAPI.domain.model;

import java.util.Date;

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

    private final Date startDate;

    private final Date endDate;

    private final double price;

    private final String currency;

    private final int priority; 

}
