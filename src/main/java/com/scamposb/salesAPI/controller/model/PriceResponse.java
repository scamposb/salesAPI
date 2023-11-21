package com.scamposb.salesAPI.controller.model;

import java.util.Date;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceResponse {
    private int ProductID;

    private int BrandID;

    private int Fee;

    private List<Date> ApplicationDates;

    private Double Price;
}
