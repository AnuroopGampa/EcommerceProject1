/*package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;
@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class TestSupplier {
	//@Autowired
		//private static Supplier supplier;
		@Autowired
		private static SupplierDAO supplierDAO;
		
			
		@BeforeClass
		public static void initialize()
		{
			@SuppressWarnings("resource")
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			
				//supplier = (Supplier) context.getBean("supplier");
				supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		}
		@Ignore
		@Test
		public void createSupplierTestCase()
		{
			Supplier supplier= new Supplier();
			supplier.setSupplier_name("Eclairs");
				supplierDAO.createSupplier(supplier);
				boolean flag=supplierDAO.createSupplier(supplier);
				
				assertEquals("createsupplierTestCase",true,flag);

			} 
		@Test
		public void deleteSupplierTestCase()
		
		{

			Supplier supplier= new Supplier();
			supplier.setSupplier_name("Eclairs");

				boolean flag=supplierDAO.deleteSupplier(25);
				
				assertEquals("createsupplierTestCase",true,flag);
		}
}
*/