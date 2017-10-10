package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.dao.ProductDAO;
import com.niit.hbconfig.HbConfig;
import com.niit.model.Product;
@SuppressWarnings("unused")
@ComponentScan("com.niit")
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
		context.register(HbConfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		//product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	@Test
	public void createProduct(){
		Product product= new Product();
		
		product.setProduct_name("cream donut");
		product.setDescription("small");
		//product.setPrice(20);
		product.setQuantity(10);
	
	
boolean flag=productDAO.createProduct(product);
		
		assertEquals("createProductTestCase", true, flag);
	
	}
	public void retrieveProduct()
	{
		Product product=new Product();
		boolean listproduct=productDAO.getProduct(12);
		assertEquals("problem in getting by id",product);
	}
	@Ignore
	@Test
	public void deleteProduct1()
	{
		Product product = new Product();
		product.setProduct_name("kitkat");
		product.setQuantity(2);
		product.setDescription("small");;
		product.setPrice(567.78);
		boolean flag=productDAO.deleteProduct(23);
		assertEquals("createProductTestCase", true, flag);
	}
	@Ignore
	@Test
	public void updateProduct1()
	{
		Product product = new Product();
		boolean flag=productDAO.updateProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
}

