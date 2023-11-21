package com.scamposb.salesAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scamposb.salesAPI.controller.mappers.ProductPriceMapper;
import com.scamposb.salesAPI.controller.model.ProductPriceRequest;
import com.scamposb.salesAPI.controller.model.ProductPriceResponse;
import com.scamposb.salesAPI.repository.PricesRepository;
import com.scamposb.salesAPI.service.ProductFeeService;
import com.scamposb.salesAPI.service.model.ProductFee;
import com.scamposb.salesAPI.service.model.ProductInfo;

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
            ProductPriceMapper mapper = new ProductPriceMapper();

            ProductFeeService pfService = new ProductFeeService(pricesRepository);
            ProductInfo productInfo = mapper.fromProductPriceRequestToProductFee(new ProductPriceRequest(productID, brandID, requestDate));
            ProductFee productFee = pfService.getPriceByDate(productInfo);   
            
            if(productFee == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } 

            ProductPriceResponse productPriceResponse = mapper.fromProductFeetoProductPriceResponseMapper(productFee);

            return new ResponseEntity<>(productPriceResponse, HttpStatus.OK); 
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
           
    }
   
}
