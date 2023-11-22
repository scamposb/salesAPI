package com.scamposb.salesAPI.infrastructure.model;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProductPriceError {

    private final Date timestamp;

    private final int status;

    private final String error;

    private final String path;

}
