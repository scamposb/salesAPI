package com.scamposb.salesAPI.controller.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.scamposb.salesAPI.controller.model.ProductPriceRequest;
import com.scamposb.salesAPI.controller.model.ProductPriceResponse;
import com.scamposb.salesAPI.service.model.ProductFee;
import com.scamposb.salesAPI.service.model.ProductInfo;

public class ProductPriceMapper {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss", Locale.ENGLISH);

    public ProductPriceResponse fromProductFeetoProductPriceResponseMapper(ProductFee productFee){
        String startDate = formatter.format(productFee.getStartDate());   
        String endDate = formatter.format(productFee.getEndDate()); 

        return new ProductPriceResponse(productFee.getProductID(), productFee.getBrandID(), 
            productFee.getFee(), startDate, endDate, productFee.getPrice());
        
    }

    public ProductInfo fromProductPriceRequestToProductFee(ProductPriceRequest pprequest){
        if(pprequest == null || pprequest.getBrandID() == null || pprequest.getProductID() == null || pprequest.getRequestedDate() == null){
            return null;
        }else{
            try{
                Date requestedDate = formatter.parse(pprequest.getRequestedDate());

                return new ProductInfo(pprequest.getProductID(), pprequest.getBrandID(), requestedDate);
            }catch(ParseException e){
                return null;
            }
            
        }
    }
    
}
