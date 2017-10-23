/*package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.Dbconfig;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductTest {
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.register(Dbconfig.class);
		context.refresh();
		
	//	product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
		
		
	}
	@Ignore
	@Test
	public void createProduct()
	{
Product product= new Product();
		
		product.setName("U.S Pollo");
		product.setQuantity(20);
		product.setPrice(30000);
boolean flag=productDAO.saveProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
	}
	@Ignore
	@Test
	public void retrieveProduct()
	{
		Product product=new Product();
		boolean listproduct=productDAO.getProduct(10);
		assertNotNull("problem in getting by id", product);
	}
	@Ignore
	@Test
	public void deleteProduct()
	{
		Product product = new Product();
		product.setName("U.S Polo");
		product.setQuantity(20);
		product.setPrice(300000);
		boolean flag=productDAO.deleteProduct(13);
		assertEquals("createProductTestCase", true, flag);
	}
	@Test
	public void updateProduct()
	{
		Product product = new Product();
		boolean flag=productDAO.updateProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
}
*/