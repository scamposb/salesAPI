package com.scamposb.salesAPI.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.scamposb.salesAPI.domain.model.ProductInfo;
import com.scamposb.salesAPI.infrastructure.model.ProductPriceRequest;

public class DomainAdapter {
public ProductInfo fromProductPriceRequestToProductFee(ProductPriceRequest pprequest){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss", Locale.ENGLISH);

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
