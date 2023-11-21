package com.scamposb.salesAPI.service.mappers;

import com.scamposb.salesAPI.model.Prices;
import com.scamposb.salesAPI.service.model.ProductFee;

public class PriceMappers {
    
    public ProductFee fromPriceToProductFeeMapper(Prices price){

        return new ProductFee(price.getProductID(), price.getBrandID(), 
            price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getPrice(), price.getCurr(), price.getPriority());
    }
}
