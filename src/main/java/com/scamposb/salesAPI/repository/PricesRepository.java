package com.scamposb.salesAPI.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scamposb.salesAPI.model.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices,Integer>{

    @Query(
        value = "SELECT product_id, brand_id, price_list, start_date, end_date, price, priority,curr FROM prices WHERE product_id = :productID AND brand_id = :brandID AND start_date <= :feeDate AND end_date >= :feeDate",
        nativeQuery = true
    )
    List<Prices> findPriceByDate(long productID, int brandID, Date feeDate);
}
