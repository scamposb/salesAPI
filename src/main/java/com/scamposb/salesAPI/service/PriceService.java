package com.scamposb.salesAPI.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.scamposb.salesAPI.repository.PricesRepository;
import com.scamposb.salesAPI.service.model.ProductFee;
import com.scamposb.salesAPI.model.Prices;

@Service
public class PriceService {

    PricesRepository pricesRepository;

    public PriceService(PricesRepository repository) {
         this.pricesRepository = repository;
       }
    
    public ProductFee getPriceByDate(long productID, int brandID, Date feeDate) {

        List<Prices> feePrices = pricesRepository.findPriceByDate(productID, brandID,feeDate);
        

        if(feePrices.size() > 1){
            /* In case of there are more than one option, we have to see the priority of each one */
            ProductFee majorPriority = null;

            for (Prices price: feePrices) {
                if(majorPriority == null || (price.getPriority() > majorPriority.getPriority())){
                    List<Date> dates = new ArrayList<Date>();
                    dates.add(price.getStartDate());
                    dates.add(price.getEndDate());

                    majorPriority = new ProductFee(price.getProductID(), price.getBrandID(), 
                        price.getPriceList(), dates, price.getPrice(), price.getCurr(), price.getPriority());

                    continue;
                }
            }

            return majorPriority;

        }else if(feePrices.size() == 1){
            Prices feePrice = feePrices.get(0);

            List<Date> dates = new ArrayList<Date>();
            dates.add(feePrice.getStartDate());
            dates.add(feePrice.getEndDate());

            return new ProductFee(feePrice.getProductID(), feePrice.getBrandID(), 
                feePrice.getPriceList(), dates, feePrice.getPrice(), feePrice.getCurr(), feePrice.getPriority());

        }
        
        return null;
    }
}
