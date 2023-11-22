package com.scamposb.salesAPI.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scamposb.salesAPI.adapters.*;
import com.scamposb.salesAPI.application.PriceHandler;
import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.domain.model.ProductInfo;
import com.scamposb.salesAPI.infrastructure.model.ProductPriceRequest;
import com.scamposb.salesAPI.infrastructure.model.ProductPriceResponse;
import com.scamposb.salesAPI.persistence.repository.PricesRepository;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class ProductPriceController {

    @Autowired
    private PricesRepository pricesRepository;
    
    @GetMapping("/price")
    public ResponseEntity<ProductPriceResponse> getProductFee(
        @RequestParam(name = "request_date", required = true) String requestDate,
        @RequestParam(name = "product_id", required = true) Long productID,
        @RequestParam(name = "brand_id", required = true) Integer brandID
        ){
        try{
            DomainAdapter domainAdapter = new DomainAdapter();
            InfraAdapter infraAdapter = new InfraAdapter();

            ProductInfo productInfo = domainAdapter.fromProductPriceRequestToProductFee(new ProductPriceRequest(productID, brandID, requestDate));
            PriceHandler priceHandler = new PriceHandler();
            ProductFee productFee = priceHandler.getPriceByDateUseCase(pricesRepository, productInfo);  
            
            if(productFee == null){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } 

            ProductPriceResponse productPriceResponse = infraAdapter.fromProductFeetoProductPriceResponseMapper(productFee);

            return new ResponseEntity<>(productPriceResponse, HttpStatus.OK); 
            
        }
        catch(ParseException e){
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
           
    }
   
}
