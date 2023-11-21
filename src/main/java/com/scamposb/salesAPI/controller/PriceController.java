package com.scamposb.salesAPI.controller;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scamposb.salesAPI.repository.PricesRepository;
import com.scamposb.salesAPI.service.PriceService;
import com.scamposb.salesAPI.service.model.ProductFee;

@RestController
@RequestMapping("/api")
public class PriceController {

    @Autowired
    private PricesRepository pricesRepository;
    
    @GetMapping("/price")
    public ResponseEntity<ProductFee> getProductFee(
        @RequestParam(name = "request_date", required = true) String requestDate,
        @RequestParam(name = "product_id", required = true) int productID,
        @RequestParam(name = "brand_id", required = true) int brandID
        ){
        try{
            PriceService priceService = new PriceService(pricesRepository);

            // TODO map from request to domain and validate date
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss", Locale.ENGLISH);
            Date date = formatter.parse(requestDate);

            ProductFee productFee = priceService.getPriceByDate(productID,brandID,date);   
            
            if(productFee == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }   // TODO inside the mapper

            // TODO apply mapper to response

            return new ResponseEntity<>(productFee, HttpStatus.OK);    //TODO
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
           
    }

   
}
