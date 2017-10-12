package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class TestCategory {
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
		@Test
		public void createCategory()
	{
	   Category category= new Category();
	   category.setCatDescription("Good Taste");
	   category.setCatName("ice cream");
	   boolean flag=categoryDAO.createCategory(category);
	   assertEquals("creatCategoryTest",true,flag);
	}
	}
	


