package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.Test;

import com.cg.beans.Product;
import com.cg.beans.ProductDetails;
import com.cg.beans.User;
import com.cg.beans.UserDetails;
import com.cg.service.RetailShopService;
import com.cg.service.RetailShopServiceImpl;

class OldEmployeeTest {

	@Test
	void test() {
		RetailShopService retail=new RetailShopServiceImpl();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		
		user.setUserId(2);
		user.setUserName("Harsha");
		user.setUsertype(UserDetails.CUSTOMER);
		LocalDate date = LocalDate.parse("2015-07-28");
		user.setRegistrationDate(date);
		product.setProductId(503433);
		product.setProductName("Sunflower OilPacket");
		product.setProductType(ProductDetails.GROCERIES);
		product.setQuantity(6);
		product.setRatePerQuantity(92);
		
		list.add(product);
		product1.setProductId(976100);
		product1.setProductName("Amul Cream");
		product1.setProductType(ProductDetails.DAIRYPRODUCTS);
		product1.setQuantity(7);
		product1.setRatePerQuantity(70);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(280,bill);
}

}
