package com.scamposb.salesAPI.adapters;

import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.persistence.repository.model.Prices;

public class PersistenceAdapter {
    
    public ProductFee fromPriceToProductFee(Prices price){

        return new ProductFee(price.getProductID(), price.getBrandID(), 
            price.getPriceList(), price.getStartDate(), price.getEndDate(), price.getPrice(), price.getCurr(), price.getPriority());
    }
}
