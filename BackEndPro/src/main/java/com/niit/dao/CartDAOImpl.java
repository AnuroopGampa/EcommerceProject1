package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CartDAO cartDAO;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	} 
	
	public CartDAO getCartDAO() {
		return cartDAO;
	}
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.cartDAO = cartDAO;
	}
	public boolean saveCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cart);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return false;
	}

	public boolean deleteCart(int Cid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cart WHERE Cid = "+Cid).executeUpdate();
		return false;
	}

	public List<Cart> getAllCartList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCart(int Cid) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getCartbyId(int Cid) {
		// TODO Auto-generated method stub
		return false;
	}
	

	}


