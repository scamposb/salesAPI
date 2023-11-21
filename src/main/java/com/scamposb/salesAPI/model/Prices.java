package com.scamposb.salesAPI.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prices")
@Data
public class Prices {
    
    @Id
    @Column(name = "price_list")
    private int priceList;

    @Column(name = "brand_id")
    private int brandID;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "product_id")
    private long productID;

    @Column(name = "priority")
    private int priority;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    private String curr;

}
