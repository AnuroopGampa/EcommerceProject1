package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.User;


public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO()
	{
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO=userDAO;
	}
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return false;
	}

	public boolean getUser(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Product1 p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 User u = (User)o;
			 System.out.println("User id : "+u.getUserId());
			 System.out.println("User Name : "+u.getUserName());
			 System.out.println("User MobileNum : "+u.getMobileNumber());
			 System.out.println("User Address : "+u.getUseraddress());
			 System.out.println("User Email : "+u.getEmail());
			 System.out.println("----------------------");
		 } 
		return true;
	}

	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = "+id).executeUpdate();
		 return true;
		
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(User.class,new Integer(140));
		 User s=(User)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setMobileNumber(123456789);  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}

}
