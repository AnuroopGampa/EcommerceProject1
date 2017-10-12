package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.hbconfig.HbConfig;
import com.niit.model.User;

public class TestUser {
	//@Autowired
		//private static User user;
		@Autowired
		private static UserDAO userDAO;
		
		
		@SuppressWarnings("resource")
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.register(HbConfig.class);
			context.scan("com.niit.*");
			context.refresh();
			
			//user = (User) context.getBean("user");
			userDAO = (UserDAO) context.getBean("userDAO");
		}
		@Test
		public void createUser(){
			User user= new User();
			user.setEmail("Abcd@gamil.com");
			user.setMobileNumber(123456);
			user.setUseraddress("abchdjff");
			user.setUserName("abcdef");
			
	boolean flag=userDAO.createUser(user);
			
			assertEquals("createUserTestCase", true, flag);
		
		}
		@Ignore
		@Test
		public void retrieveUser()
		{
			User user=new User();
			boolean listproduct=userDAO.getUser(12);
			assertNotNull("problem in getting by id", user);
		}
		@Ignore
		@Test
		public void deleteUser()
		{
			User user=new User();
			user.setEmail("ancd@gmail.com");
			user.setMobileNumber(1245678);
			user.setUserName("abcd");
			user.setUseraddress("abcdgfh");
			
			
			boolean flag=userDAO.deleteUser(37);
			assertEquals("createUserTestCase", true, flag);
		}
		@Ignore
		@Test
		public void updateUser()
		{
			User user=new User();
			boolean flag=userDAO.updateUser(user);
			assertEquals("createUserTestCase", true, flag);
		}
}
