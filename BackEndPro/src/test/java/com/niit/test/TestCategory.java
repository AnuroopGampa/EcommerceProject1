/*package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class TestCategory {
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(ApplicationContextConfig.class);
		context.scan("com.niit.*");
		context.refresh();
	
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	@Test
	public void saveCategory()
	{
		Category category=new Category();
		category.setCategory_Name("BOOKS");
		category.setCategory_Description("Fiction books");
		boolean flag=categoryDAO.saveCategory(category);
		assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=new Category();
		boolean flag=categoryDAO.updateCategory(1);
		assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Test
	public void getAllCategoryList()
	{
		Category category=new Category();
		List<Category> flag=categoryDAO.getAllCategoryList();
		assertNotNull("problrm in getting category by Cid", category);
	}
}
*/