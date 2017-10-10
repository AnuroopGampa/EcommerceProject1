package com.niit.TestCase;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.query.Query;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.config.Dbconfig;
import com.niit.dao.Product1DAO;
import com.niit.model.Product1;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class Product1Test 
{	
	
	//@Autowired
	//private static Product product;
	

	@Autowired
	private static Product1DAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		
		context.refresh();
		
		Product1 product=(Product1) context.getBean("product");
		productDAO=(Product1DAO) context.getBean("productDAO");
	
	}
	/*@Test
	public void createProduct1()
	{
		Product1 product=new Product1();
		product.setName("Icecream");
		product.setPrice(7689.90);
		product.setQuantity(9);
		product.setP_category("Orange Flavour");
		
		product.setName("choclate");
		product.setPrice(1200.90);
		product.setQuantity(9);
		product.setP_category("Orange Flavour");	
		boolean flag=productDAO.saveProduct1(product);
		assertEquals("createProductTestCase", true, flag);
	}*/ 
/*@Test
	public void addProduct()
	{
		Product1 product = new Product1();
		productDAO.addProduct(product);
		product.setName("chocobar");
		product.setP_category("Arun");
		product.setPrice(100);
		product.setQuantity(10);
		boolean flag=productDAO.saveProduct1(product);
		assertEquals("createProductTestCase", true, flag);
	}*/
	/*@Test
	public void deleteProduct1()
	{
		productDAO.deleteProduct1(111);
	}*/


}


