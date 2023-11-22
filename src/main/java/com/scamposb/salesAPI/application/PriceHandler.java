package com.scamposb.salesAPI.application;

import com.scamposb.salesAPI.domain.ProductFeeService;
import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.domain.model.ProductInfo;
import com.scamposb.salesAPI.persistence.repository.PricesRepository;

public class PriceHandler {

    public ProductFee getPriceByDateUseCase(PricesRepository pricesRepository, ProductInfo productInfo){

        ProductFeeService pfService = new ProductFeeService(pricesRepository);
        return pfService.getPriceByDate(productInfo); 
    }
}
