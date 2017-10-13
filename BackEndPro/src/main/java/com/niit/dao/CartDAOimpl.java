package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Cart;

public class CartDAOimpl implements CartDAO 
{
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactroy;
	
	@Autowired
	private CartDAO cartDAO;
	
	public CartDAO getCartDAO()
	{
		return cartDAO;
	}
	
	public void setCartDAO(CartDAO cartDAO)
	{
		this.cartDAO=cartDAO;
	}

	public CartDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactroy=sessionFactory;
	}
	@Transactional
	public boolean createCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactroy.openSession();
		session.saveOrUpdate(cart);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}

	public boolean getCart(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactroy.openSession();
		Query qry = session.createQuery("from Product1 p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Cart c = (Cart)o;
			 System.out.println("Product id : "+c.getCartid());
			 System.out.println("Product Name : "+c.getPrice());
			 System.out.println("Product Price : "+c.getCatid());
			 System.out.println("Product Price : "+c.getProductid());
			 System.out.println("Product Price : "+c.getProductname());
			 System.out.println("Product Price : "+c.getQuantity());
			 System.out.println("Product Price : "+c.getStatus());
			 System.out.println("Product Price : "+c.getUsername());
			 System.out.println("----------------------");
		 } 
		return true;
	}

	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactroy.openSession();
		 Object o=session.load(Cart.class,new Integer(140));
		 Cart c=(Cart)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 c.setQuantity(10);  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
		
	}

	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		sessionFactroy.getCurrentSession().createQuery("DELETE FROM Cart WHERE id = "+id).executeUpdate();
		return true;
	}

}
