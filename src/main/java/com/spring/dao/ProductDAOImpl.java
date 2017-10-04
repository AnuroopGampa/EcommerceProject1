
package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;


@Repository
public class ProductDAOImpl implements ProductDAO 
{
		
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveProduct1(Product product) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getAllProducts() 
	{
		
		return sessionFactory.getCurrentSession().createQuery("from Product1").list();
	}
	
	@Transactional
	public void deleteProduct1(int id) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product1 WHERE id = "+id).executeUpdate();
		
	}

	@Transactional
	public void addProduct(Product product) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}