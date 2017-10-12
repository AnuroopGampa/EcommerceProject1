package com.niit.hbconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategortDAOImpl;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class HbConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa"); 
		System.out.println("Datasource");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		/*properties.put("hbm2ddl.auto", "create");*/
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
	
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.scanPackages("com.niit");

		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}

	
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getproductDetailsDAO(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
	}

	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDetailsDAO(SessionFactory sessionFactory) {
			return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDetailsDAO(SessionFactory sessionFactory)
	{
		return new CategortDAOImpl(sessionFactory);
	}
}