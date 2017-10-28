package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Card;

public class CardDAOImpl implements CardDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public CardDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	@Transactional
	public boolean saveCard(Card card) {
		// TODO Auto-generated method stub
sessionFactory.getCurrentSession().saveOrUpdate(card);
		
		return true;
	}

}
