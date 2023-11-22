package com.scamposb.salesAPI.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductInfo {
    private final long productID;

    private final int brandID;

    private final Date infoDate;

}
