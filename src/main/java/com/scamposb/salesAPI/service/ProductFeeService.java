package com.scamposb.salesAPI.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.scamposb.salesAPI.repository.PricesRepository;
import com.scamposb.salesAPI.service.mappers.PriceMappers;
import com.scamposb.salesAPI.service.model.ProductFee;
import com.scamposb.salesAPI.service.model.ProductInfo;
import com.scamposb.salesAPI.model.Prices;

@Service
public class ProductFeeService {

    PricesRepository pricesRepository;

    public ProductFeeService(PricesRepository repository) {
         this.pricesRepository = repository;
    }
    
    public ProductFee getPriceByDate(ProductInfo productInfo) {

        PriceMappers mapper = new PriceMappers();
        List<Prices> feePrices = pricesRepository.findPriceByDate(productInfo.getProductID(), productInfo.getBrandID(),productInfo.getInfoDate());
        

        if(feePrices.size() > 1){
            /* In case of there are more than one option, we have to see the priority of each one */
            ProductFee majorPriority = null;

            for (Prices price: feePrices) {
                if(majorPriority == null || (price.getPriority() > majorPriority.getPriority())){
                    majorPriority = mapper.fromPriceToProductFeeMapper(price);

                    continue;
                }
            }

            return majorPriority;

        }else if(feePrices.size() == 1){

            return mapper.fromPriceToProductFeeMapper(feePrices.get(0));
        }
        
        return null;
    }

}