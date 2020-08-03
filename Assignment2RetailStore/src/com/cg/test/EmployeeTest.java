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
class EmployeeTest {

	@Test
	void test() {
		
		RetailShopService retail=new RetailShopServiceImpl();
		List<Product> list=new ArrayList<Product>();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		
		user.setUserId(1);
		user.setUserName("Mintu");
		user.setUsertype(UserDetails.EMPLOYEE);
		user.setRegistrationDate(LocalDate.now());
		
		product.setProductId(5078);
		product.setProductName("Aashirvaad MultiGrain Atta");
		product.setProductType(ProductDetails.GROCERIES);
		product.setQuantity(2);
		product.setRatePerQuantity(78);
		
		list.add(product);
		product1.setProductId(1003452);
		product1.setProductName("MILK");
		product1.setProductType(ProductDetails.DAIRYPRODUCTS);
		product1.setQuantity(5);
		product1.setRatePerQuantity(32);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(165, bill);
		}

}
