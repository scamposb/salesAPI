package com.scamposb.salesAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scamposb.salesAPI.domain.ProductFeeService;
import com.scamposb.salesAPI.domain.model.ProductFee;
import com.scamposb.salesAPI.domain.model.ProductInfo;

@SpringBootTest
class SalesApiApplicationTests {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss", Locale.ENGLISH);

	@Autowired
	private ProductFeeService productFeeService;


	/**
	 * Given a certain productID, brandID and a requestedDate
	 * When a price is requested to h2 database
	 * Then the expectedPrice is returned
	 * @param ProductID product identificator
	 * @param brandID brand identificator
	 * @param requestedDate date which we need to know the product price
	 * @param expectedPrice the price that we expected
	 * @throws ParseException returns when the date format is invalid
	 */
	@ParameterizedTest
	@CsvSource({"35455,1,2020-06-14-10.00.00,35.50",
				"35455,1,2020-06-14-16.00.00,25.45",
				"35455,1,2020-06-14-21.00.00,35.50",
				"35455,1,2020-06-15-10.00.00,30.50",
				"35455,1,2020-06-16-21.00.00,38.95"})
	void RequestedTests(long ProductID, int brandID, String requestedDate, double expectedPrice) throws ParseException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
        	Date date = dateFormat.parse(requestedDate);

			ProductInfo productInfo = new ProductInfo(35455, 1, date);
			ProductFee given = productFeeService.getPriceByDate(productInfo);

			assertNotNull(given);
        	assertEquals(productInfo.getProductID(), given.getProductID());
        	assertEquals(productInfo.getBrandID(), given.getBrandID());
        	assertEquals(expectedPrice, given.getPrice());

	}

	/**
	 * Given a certain productID, brandID different than 1 and a requestedDate
	 * When a price is requested to h2 database
	 * Then it returns a the expected price
	 * @throws ParseException returns when the date format is invalid
	 */
	@Test
	void TestOtherBrand() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		Date date = dateFormat.parse("2020-06-14-10.00.00,35.50");

		ProductInfo productInfo = new ProductInfo(11111, 2, date);
		ProductFee given = productFeeService.getPriceByDate(productInfo);

		assertNotNull(given);
		assertEquals(productInfo.getProductID(), given.getProductID());
		assertEquals(productInfo.getBrandID(), given.getBrandID());
		assertEquals(1, given.getPrice());
	}


	/**
	 * Given a certain productID which not belongs to the brandID
	 * When a price is requested to h2 database
	 * Then it returns a null price
	 * @throws ParseException returns when the date format is invalid
	 */
	@Test
	void TestUnknownProduct() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		Date date = dateFormat.parse("2020-06-14-10.00.00,35.50");

		ProductInfo productInfo = new ProductInfo(4848, 1, date);
		ProductFee given = productFeeService.getPriceByDate(productInfo);

		assertNull(given);
	}

}
