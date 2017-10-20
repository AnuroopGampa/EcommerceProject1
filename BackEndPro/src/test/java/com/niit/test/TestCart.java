/*package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.CartDAO;
import com.niit.model.Cart;

@ComponentScan("com.niit")
public class TestCart {
	@Autowired
	private static CartDAO cartDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(ApplicationContextConfig.class);
		context.scan("com.niit.*");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	@Test
	public void createCart()
	{
		Cart cart=new Cart();
		cart.setCatid(10);
		cart.setPrice(100.23);
		cart.setProductid(23);
		cart.setProductname("ice cream");
		cart.setQuantity(10);
		cart.setStatus("y");
		cart.setUsername("Anuroop");

		boolean flag=cartDAO.createCart(cart);
		assertEquals("creatCartTestCase",true,flag);
	}
	@Ignore
	@Test
	
	public void updateCart()
	{
		Cart cart = new Cart();
		boolean flag=cartDAO.updateCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
	@Ignore
	@Test
	public void deleteCart()
	{
		Cart cart = new Cart();
		cart.setCatid(10);
		cart.setPrice(100.23);
		cart.setProductid(23);
		cart.setProductname("ice cream");
		cart.setQuantity(10);
		cart.setStatus("y");
		cart.setUsername("Anuroop");
		boolean flag=cartDAO.deleteCart(39);
		assertEquals("createCartTestCase", true, flag);
	}
	
	

}



*/