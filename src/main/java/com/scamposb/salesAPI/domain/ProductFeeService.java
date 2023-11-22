package com.scamposb.salesAPI.domain;

import java.util.List;
import org.springframework.stereotype.Service;

import com.scamposb.salesAPI.adapters.PersistenceAdapter;
import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.domain.model.ProductInfo;
import com.scamposb.salesAPI.persistence.repository.PricesRepository;
import com.scamposb.salesAPI.persistence.repository.model.Prices;

@Service
public class ProductFeeService {

    PricesRepository pricesRepository;

    public ProductFeeService(PricesRepository repository) {
         this.pricesRepository = repository;
    }
    
    public ProductFee getPriceByDate(ProductInfo productInfo) {

        PersistenceAdapter adapter = new PersistenceAdapter();
        List<Prices> feePrices = pricesRepository.findPriceByDate(productInfo.getProductID(), productInfo.getBrandID(),productInfo.getInfoDate());
        

        if(feePrices.size() > 1){
            /* In case of there are more than one option, we have to see the priority of each one */
            ProductFee majorPriority = null;

            for (Prices price: feePrices) {
                if(majorPriority == null || (price.getPriority() > majorPriority.getPriority())){
                    majorPriority = adapter.fromPriceToProductFee(price);

                    continue;
                }
            }

            return majorPriority;

        }else if(feePrices.size() == 1){

            return adapter.fromPriceToProductFee(feePrices.get(0));
        }
        
        return null;
    }

}