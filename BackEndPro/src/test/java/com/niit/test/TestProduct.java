/*package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class TestProduct {
	//@Autowired
	//private static Product product;
	@Autowired
	private static ProductDAO productDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationContextConfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		//product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void createProduct(){
		Product product= new Product();
		
		product.setProduct_name("cake");
		product.setDescription("small");
		product.setPrice(20);
		product.setQuantity(10);
boolean flag=productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
	
	}
	@Ignore
	@Test
	public void retrieveProduct()
	{
		Product product=new Product();
		boolean listproduct=productDAO.getProduct(12);
		assertNotNull("problem in getting by id", product);
	}
	@Ignore
	@Test
	public void deleteProduct()
	{
		Product product = new Product();
		product.setProduct_name("cream donut");
		product.setQuantity(10);
		product.setDescription("small");;
		product.setPrice(0.0);
		boolean flag=productDAO.deleteProduct(25);
		assertEquals("createProductTestCase", true, flag);
	}
	@Ignore
	@Test
	public void updateProduct()
	{
		Product product = new Product();
		boolean flag=productDAO.updateProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
}
*/