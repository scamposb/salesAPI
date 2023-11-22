package com.scamposb.salesAPI.adapters;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.infrastructure.model.ProductPriceResponse;

public class InfraAdapter {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss", Locale.ENGLISH);

    public ProductPriceResponse fromProductFeetoProductPriceResponseMapper(ProductFee productFee){
        String startDate = formatter.format(productFee.getStartDate());   
        String endDate = formatter.format(productFee.getEndDate()); 

        return new ProductPriceResponse(productFee.getProductID(), productFee.getBrandID(), 
            productFee.getFee(), startDate, endDate, productFee.getPrice());
        
    }
}
