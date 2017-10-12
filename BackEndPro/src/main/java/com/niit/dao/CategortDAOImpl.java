package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository
public class CategortDAOImpl implements CategoryDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryDAO getCategoryDAO()
	{
		return categoryDAO;
	}
	public void setcategoryDAO(CategoryDAO categoryDAO)
	{
		this.categoryDAO=categoryDAO;
	}

	public CategortDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Category WHERE id = "+id).executeUpdate();
		return false;
	}

	/*public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return null;
	}*/

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Category.class,new Integer(140));
		 Category s=(Category)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setCatName("chocolate");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		return true;
	}

	public boolean getCategory(int id) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Category c");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Category c = (Category)o;
			 System.out.println("Category id : "+c.getCatid());
			 System.out.println("Category Name : "+c.getCatName());
			 System.out.println("Category Description : "+c.getCatDescription());;
			 System.out.println("----------------------");
		 } 

		return true;
		
	}
	
	@Transactional
	public boolean createCategory(Category category) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.persist(category);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}

	

}
