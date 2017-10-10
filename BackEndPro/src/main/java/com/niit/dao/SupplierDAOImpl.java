package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SupplierDAO supplierDAO;
	
	public boolean createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.persist(supplier);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return false;
	}
	public SupplierDAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	public boolean getSupplier(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Product1 p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Supplier s = (Supplier)o;
			 System.out.println("Supplier id : "+s.getId());
			 System.out.println("Product Name : "+s.getSupplier_name());
			
			 System.out.println("----------------------");
		 } 

		return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Supplier.class,new Integer(14));
		 Supplier sp=(Supplier)o;
		 
		 Transaction tx = session.beginTransaction(); 
		sp.setSupplier_name("Cadbury");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	
	}

	public boolean deleteSupplier(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Supplier WHERE id = "+id).executeUpdate();
		return true;
	}

	}

