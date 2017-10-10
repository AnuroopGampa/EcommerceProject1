package com.niit.dao;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	@Autowired
	private ProductDAO productDAO;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	

	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		session.persist(product);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}

	@SuppressWarnings("rawtypes")
	public boolean getProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from product p");
		List l=q.getResultList();
		System.out.println("Totaal number of records:"+l.size());;
		Iterator it=l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Product p = (Product)o;
			 System.out.println("Product id : "+p.getId());
			 System.out.println("Product Name : "+p.getProduct_name());
			 System.out.println("Product Price : "+p.getPrice());
			 System.out.println("----------------------");
		 } 
		return true;
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Product.class,new Integer(23));
		 Product s=(Product)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setPrice(678.9);  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		return true;
	}

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product1 WHERE id = "+id).executeUpdate();
		return true;
	}
}
