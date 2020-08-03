package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.beans.Product;
import com.cg.beans.ProductDetails;
import com.cg.beans.User;
import com.cg.beans.UserDetails;
import com.cg.service.RetailShopService;
import com.cg.service.RetailShopServiceImpl;

//import org.junit.jupiter.api.Test;



class AffiliateTest {
	
	@Test
	void test() {
		
		RetailShopService retail=new RetailShopServiceImpl();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		
		user.setUserId(2);
		user.setUserName("Bhantu");
		user.setUsertype(UserDetails.AFFILIATE );
		user.setRegistrationDate(LocalDate.now());
		
		product.setProductId(182938);
		product.setProductName("Colgate ToothPaste");
		product.setProductType(ProductDetails.GROCERIES);
		product.setQuantity(1);
		product.setRatePerQuantity(56);
		list.add(product);
		
		product1.setProductId(10037282);
		product1.setProductName("Curd");
		product1.setProductType(ProductDetails.DAIRYPRODUCTS);
		product1.setQuantity(3);
		product1.setRatePerQuantity(42);
		list.add(product1);
		
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(185, bill);
		
	}


}
